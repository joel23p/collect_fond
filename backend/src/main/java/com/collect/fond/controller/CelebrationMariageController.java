package com.collect.fond.controller;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.collect.fond.facade.CelebrationMariageFacade;
import com.collect.fond.presentation.dto.CelebrationMariageDto;
import com.collect.fond.utils.DateEnLettres;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ws/demande-mariage")
@SecurityRequirement(name = "Authorization")
public class CelebrationMariageController {
    private final CelebrationMariageFacade  celebrationMariageFacade ;

    public CelebrationMariageController( CelebrationMariageFacade celebrationMariageFacade) {
        this.celebrationMariageFacade = celebrationMariageFacade;
    }

    @GetMapping("/lister")
    public List<CelebrationMariageDto> lister() {
        return celebrationMariageFacade.lister();
    }

    @PostMapping("/enregistrer")
    public void enregistrer(@RequestBody CelebrationMariageDto celebrationMariageDto) {
        celebrationMariageFacade.enregistrer(celebrationMariageDto);
    }

    @GetMapping("/recuperer/{id}")
    public CelebrationMariageDto recuperer(@PathVariable Long id) {
        return celebrationMariageFacade.recuperer(id);
    }

    @GetMapping("/generer-acte/{id}")
    public Map<String, String> genererActe(@PathVariable Long id) throws java.io.IOException {
        CelebrationMariageDto dto = celebrationMariageFacade.recuperer(id);
        PdfReader reader = new PdfReader("src/main/resources/modeles/acte_mariage.pdf");
        //? String pubDirPath = System.getProperty("user.dir") + "/publications";
        String pubDirPath = "src/main/resources/static/publications";
        String destRelativePath = "actes_mariage/" +
        "CM-" + dto.getDateRendezVous().getYear() + "-" + dto.getId().toString() + ".pdf";
        String destPath = pubDirPath + "/" + destRelativePath ;
        PdfWriter writer = new PdfWriter(destPath);
        PdfDocument pdfDocument = new PdfDocument(reader, writer);
        Document document = new Document(pdfDocument);
        addText(document,
                dto.getId().toString() + " du " + dto.getDateRendezVous().format(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")
                ),
                75, 645, 200
        );
        addText(document,
                dto.getNomEpoux() + " " + dto.getPrenomsEpoux(),
                75, 595, 200
        );
        addText(document,
                dto.getNomEpouse() + " " + dto.getPrenomsEpouse(),
                75, 540, 200
        );
        addText(document,
                dto.getDateRendezVous().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                440, 233, 150
        );
        addText(document,
                "POUR L'ANNEE " + String.valueOf(dto.getDateRendezVous().getYear()),
                340, 705, 150
        );

        String description = """
Le <date de célébration jusqu'à la minute en lettre> devant nous, AKRE Aka Magloire, Conseiller Municipal de la Commune de Yopougon, Officier de l'Etat Civil ont comparu publiquement à l'Hôtel Communal de Yopougon, <le nom et prénom de l'époux>, <la profession de l'époux>, né le <date naissance en lettre de l'époux> à <lieu naissance de l'époux>, domicilié à <lieu de résidence de l'époux>. Fils de <le nom et prénom du père de l'époux>, domicilié à <lieu de résidence du père de l'époux> et de <le nom et prénom de la mère de l'époux>, domicilié à <lieu de résidence de la mère de l'époux>, <situation matrimoniale époux>.
Et <le nom et prénom de l'épouse>, <la profession de l'épouse>, né le <date naissance en lettre de l'épouse> à <lieu naissance de l'épouse>, domicilié à <lieu de résidence de l'épouse>. Fils de <le nom de prénom du père de l'épouse>, domicilié à <lieu de résidence du père de l'épouse> et de <le nom et prénom de la mère de l'épouse>, domicilié à <lieu de résidence de la mère de l'épouse>, <situation matrimoniale épouse>.
Lesquelles ont déclaré sur notre interpellation opter pour le régime <de la communauté de bien ou séparation de bien>, l'un après l'autre, vouloir se prendre pour époux et nous avons prononcé, au nom de la loi, qu'ils sont unis par le mariage en présence de :
1) <nom et prénom du témoin de l'époux>, <profession du témoin de l'époux>, domicilié à <lieu de résidence du témoin de l'époux>.
2) <nom et prénom du témoin de l'épouse>, <profession du témoin de l'épouse>, domiciliée à <lieu de résidence du témoin de l'épouse>.
Avant de dresser l'acte, nous avons averti les parties comparantes et les témoins des peines prévues par la loi pour sanctionner les fausses déclarations. Lecture faite, les époux et les témoins invités à lire l'acte. Nous avons signé avec les époux et les témoins. (Sur les registres suivent les signatures).
""";
        description = description.replace("<date de célébration jusqu'à la minute en lettre>",
                DateEnLettres.dateEnLettres(dto.getDateRendezVous())
        );
        description = description.replace("<le nom et prénom de l'époux>",
                dto.getNomEpoux() + " " + dto.getPrenomsEpoux()
        );
        description = description.replace("<la profession de l'époux>",
                dto.getProfessionEpoux()
        );
        description = description.replace("<date naissance en lettre de l'époux>",
                DateEnLettres.dateEnLettres(dto.getDateNaissEpoux())
        );
        description = description.replace("<lieu naissance de l'époux>",
                dto.getLieuNaissEpoux()
        );
        description = description.replace("<lieu de résidence de l'époux>",
                "Yopougon"
        );
        description = description.replace("<le nom et prénom du père de l'époux>",
                dto.getNomPereEpoux() + " " + dto.getPrenomsPereEpoux()
        );
        description = description.replace("<lieu de résidence du père de l'époux>",
                "Yopougon"
        );
        description = description.replace("<le nom et prénom de la mère de l'époux>",
                dto.getNomPereEpouse() + " " + dto.getPrenomsPereEpouse()
        );
        description = description.replace("<lieu de résidence de la mère de l'époux>",
                "Yopougon"
        );
        description = description.replace("<situation matrimoniale époux>",
                dto.getSituationMatriEpoux()
        );
        description = description.replace("<nom et prénom du témoin de l'époux>",
                dto.getNomTemoinEpoux() + " " + dto.getPrenomsTemoinEpoux()
        );
        description = description.replace("<profession du témoin de l'époux>",
                dto.getProfessionEpoux()
        );
        description = description.replace("<lieu de résidence du témoin de l'époux>",
                "Abidjan"
        );

        description = description.replace("<le nom et prénom de l'épouse>",
                dto.getNomEpouse() + " " + dto.getPrenomsEpouse()
        );
        description = description.replace("<la profession de l'épouse>",
                dto.getProfessionEpouse()
        );
        description = description.replace("<date naissance en lettre de l'épouse>",
                DateEnLettres.dateEnLettres(dto.getDateNaissEpouse())
        );
        description = description.replace("<lieu naissance de l'épouse>",
                dto.getLieuNaissEpouse()
        );
        description = description.replace("<lieu de résidence de l'épouse>",
                "Yopougon"
        );
        description = description.replace("<le nom de prénom du père de l'épouse>",
                dto.getNomPereEpouse() + " " + dto.getPrenomsPereEpouse()
        );
        description = description.replace("<lieu de résidence du père de l'épouse>",
                "Yopougon"
        );
        description = description.replace("<le nom et prénom de la mère de l'épouse>",
                dto.getNomPereEpouse() + " " + dto.getPrenomsPereEpouse()
        );
        description = description.replace("<lieu de résidence de la mère de l'épouse>",
                "Yopougon"
        );
        description = description.replace("<situation matrimoniale épouse>",
                dto.getSituationMatriEpouse()
        );
        description = description.replace("<nom et prénom du témoin de l'épouse>",
                dto.getNomTemoinEpouse() + " " + dto.getPrenomsTemoinEpouse()
        );
        description = description.replace("<profession du témoin de l'épouse>",
                dto.getProfessionEpouse()
        );
        description = description.replace("<lieu de résidence du témoin de l'épouse>",
                "Abidjan"
        );

        description = description.replace("<de la communauté de bien ou séparation de bien>",
                dto.getRegime()
        );

        addTextItalics(document,
                description,
                200, 265, 370
        );
        // addContentToDocument(pdfDocument);
        pdfDocument.close();
        return Collections.singletonMap("chemin", destRelativePath);
    }
    protected void addText(Document document, String content, float x, float y, float width) throws java.io.IOException {
        addText(document, content, x, y, width, FontConstants.HELVETICA);
    }
    protected void addText(Document document, String content, float x, float y, float width, String fontId) throws java.io.IOException {
        PdfFont font = PdfFontFactory.createFont(fontId);
        Text contentText = new Text(content);
        Paragraph p = new Paragraph()
                .add(contentText)
                .setFont(font);
        p.setFixedPosition(x, y, width);
        document.add(p);
    }
    protected void addTextItalics(Document document, String content, float x, float y, float width) throws java.io.IOException {
        Text contentText = new Text(content).setItalic().setFontSize(11);
        Paragraph p = new Paragraph()
                .add(contentText);
        p.setFixedPosition(x, y, width);
        document.add(p);
    }
}
