/*     */ package org.apache.poi.xslf.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocument;
/*     */ import org.apache.poi.POIXMLTextExtractor;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.xslf.usermodel.DrawingParagraph;
/*     */ import org.apache.poi.xslf.usermodel.DrawingTextBody;
/*     */ import org.apache.poi.xslf.usermodel.DrawingTextPlaceholder;
/*     */ import org.apache.poi.xslf.usermodel.XMLSlideShow;
/*     */ import org.apache.poi.xslf.usermodel.XSLFCommentAuthors;
/*     */ import org.apache.poi.xslf.usermodel.XSLFComments;
/*     */ import org.apache.poi.xslf.usermodel.XSLFCommonSlideData;
/*     */ import org.apache.poi.xslf.usermodel.XSLFNotes;
/*     */ import org.apache.poi.xslf.usermodel.XSLFRelation;
/*     */ import org.apache.poi.xslf.usermodel.XSLFSlide;
/*     */ import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
/*     */ import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
/*     */ import org.apache.poi.xslf.usermodel.XSLFSlideShow;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFPowerPointExtractor
/*     */   extends POIXMLTextExtractor
/*     */ {
/*  43 */   public static final XSLFRelation[] SUPPORTED_TYPES = new XSLFRelation[] { XSLFRelation.MAIN, XSLFRelation.MACRO, XSLFRelation.MACRO_TEMPLATE, XSLFRelation.PRESENTATIONML, XSLFRelation.PRESENTATIONML_TEMPLATE, XSLFRelation.PRESENTATION_MACRO };
/*     */   
/*     */   private XMLSlideShow slideshow;
/*     */   
/*     */   private boolean slidesByDefault = true;
/*     */   
/*     */   private boolean notesByDefault = false;
/*     */   
/*     */   private boolean masterByDefault = false;
/*     */ 
/*     */   
/*     */   public XSLFPowerPointExtractor(XMLSlideShow paramXMLSlideShow) {
/*  55 */     super((POIXMLDocument)paramXMLSlideShow);
/*  56 */     this.slideshow = paramXMLSlideShow;
/*     */   }
/*     */   public XSLFPowerPointExtractor(XSLFSlideShow paramXSLFSlideShow) throws XmlException, IOException {
/*  59 */     this(new XMLSlideShow(paramXSLFSlideShow.getPackage()));
/*     */   }
/*     */   public XSLFPowerPointExtractor(OPCPackage paramOPCPackage) throws XmlException, OpenXML4JException, IOException {
/*  62 */     this(new XSLFSlideShow(paramOPCPackage));
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  66 */     if (paramArrayOfString.length < 1) {
/*  67 */       System.err.println("Use:");
/*  68 */       System.err.println("  XSLFPowerPointExtractor <filename.pptx>");
/*  69 */       System.exit(1);
/*     */     } 
/*  71 */     XSLFPowerPointExtractor xSLFPowerPointExtractor = new XSLFPowerPointExtractor(new XSLFSlideShow(paramArrayOfString[0]));
/*     */ 
/*     */     
/*  74 */     System.out.println(xSLFPowerPointExtractor.getText());
/*  75 */     xSLFPowerPointExtractor.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSlidesByDefault(boolean paramBoolean) {
/*  83 */     this.slidesByDefault = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotesByDefault(boolean paramBoolean) {
/*  90 */     this.notesByDefault = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMasterByDefault(boolean paramBoolean) {
/*  97 */     this.masterByDefault = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 104 */     return getText(this.slidesByDefault, this.notesByDefault);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText(boolean paramBoolean1, boolean paramBoolean2) {
/* 113 */     return getText(paramBoolean1, paramBoolean2, this.masterByDefault);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 123 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 125 */     List list = this.slideshow.getSlides();
/* 126 */     XSLFCommentAuthors xSLFCommentAuthors = this.slideshow.getCommentAuthors();
/*     */     
/* 128 */     for (XSLFSlide xSLFSlide : list) {
/*     */       try {
/* 130 */         XSLFNotes xSLFNotes = xSLFSlide.getNotes();
/* 131 */         XSLFComments xSLFComments = xSLFSlide.getComments();
/* 132 */         XSLFSlideLayout xSLFSlideLayout = xSLFSlide.getSlideLayout();
/* 133 */         XSLFSlideMaster xSLFSlideMaster = xSLFSlideLayout.getSlideMaster();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 139 */         if (paramBoolean1) {
/* 140 */           extractText(xSLFSlide.getCommonSlideData(), false, stringBuffer);
/*     */ 
/*     */           
/* 143 */           if (paramBoolean3) {
/* 144 */             if (xSLFSlideLayout != null) {
/* 145 */               extractText(xSLFSlideLayout.getCommonSlideData(), true, stringBuffer);
/*     */             }
/* 147 */             if (xSLFSlideMaster != null) {
/* 148 */               extractText(xSLFSlideMaster.getCommonSlideData(), true, stringBuffer);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 153 */           if (xSLFComments != null) {
/* 154 */             for (CTComment cTComment : xSLFComments.getCTCommentsList().getCmArray()) {
/*     */               
/* 156 */               if (xSLFCommentAuthors != null) {
/* 157 */                 CTCommentAuthor cTCommentAuthor = xSLFCommentAuthors.getAuthorById(cTComment.getAuthorId());
/* 158 */                 if (cTCommentAuthor != null) {
/* 159 */                   stringBuffer.append(cTCommentAuthor.getName() + ": ");
/*     */                 }
/*     */               } 
/*     */ 
/*     */               
/* 164 */               stringBuffer.append(cTComment.getText());
/* 165 */               stringBuffer.append("\n");
/*     */             } 
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 171 */         if (paramBoolean2 && xSLFNotes != null) {
/* 172 */           extractText(xSLFNotes.getCommonSlideData(), false, stringBuffer);
/*     */         }
/* 174 */       } catch (Exception exception) {
/* 175 */         throw new RuntimeException(exception);
/*     */       } 
/*     */     } 
/*     */     
/* 179 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private void extractText(XSLFCommonSlideData paramXSLFCommonSlideData, boolean paramBoolean, StringBuffer paramStringBuffer) {
/* 183 */     for (DrawingTextBody drawingTextBody : paramXSLFCommonSlideData.getDrawingText()) {
/* 184 */       if (paramBoolean && drawingTextBody instanceof DrawingTextPlaceholder) {
/* 185 */         DrawingTextPlaceholder drawingTextPlaceholder = (DrawingTextPlaceholder)drawingTextBody;
/* 186 */         if (!drawingTextPlaceholder.isPlaceholderCustom()) {
/*     */           continue;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 192 */       for (DrawingParagraph drawingParagraph : drawingTextBody.getParagraphs()) {
/* 193 */         paramStringBuffer.append(drawingParagraph.getText());
/* 194 */         paramStringBuffer.append("\n");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xslf\extractor\XSLFPowerPointExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */