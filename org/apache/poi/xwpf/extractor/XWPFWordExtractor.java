/*     */ package org.apache.poi.xwpf.extractor;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocument;
/*     */ import org.apache.poi.POIXMLTextExtractor;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.xwpf.model.XWPFCommentsDecorator;
/*     */ import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
/*     */ import org.apache.poi.xwpf.usermodel.IBodyElement;
/*     */ import org.apache.poi.xwpf.usermodel.ICell;
/*     */ import org.apache.poi.xwpf.usermodel.IRunElement;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFDocument;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFHyperlink;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFRelation;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFSDT;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFSDTCell;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFTable;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFTableCell;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFTableRow;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XWPFWordExtractor
/*     */   extends POIXMLTextExtractor
/*     */ {
/*  48 */   public static final XWPFRelation[] SUPPORTED_TYPES = new XWPFRelation[] { XWPFRelation.DOCUMENT, XWPFRelation.TEMPLATE, XWPFRelation.MACRO_DOCUMENT, XWPFRelation.MACRO_TEMPLATE_DOCUMENT };
/*     */ 
/*     */   
/*     */   private XWPFDocument document;
/*     */ 
/*     */   
/*     */   private boolean fetchHyperlinks = false;
/*     */ 
/*     */   
/*     */   public XWPFWordExtractor(OPCPackage paramOPCPackage) throws XmlException, OpenXML4JException, IOException {
/*  58 */     this(new XWPFDocument(paramOPCPackage));
/*     */   }
/*     */   
/*     */   public XWPFWordExtractor(XWPFDocument paramXWPFDocument) {
/*  62 */     super((POIXMLDocument)paramXWPFDocument);
/*  63 */     this.document = paramXWPFDocument;
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  67 */     if (paramArrayOfString.length < 1) {
/*  68 */       System.err.println("Use:");
/*  69 */       System.err.println("  XWPFWordExtractor <filename.docx>");
/*  70 */       System.exit(1);
/*     */     } 
/*  72 */     XWPFWordExtractor xWPFWordExtractor = new XWPFWordExtractor(POIXMLDocument.openPackage(paramArrayOfString[0]));
/*     */ 
/*     */ 
/*     */     
/*  76 */     System.out.println(xWPFWordExtractor.getText());
/*  77 */     xWPFWordExtractor.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFetchHyperlinks(boolean paramBoolean) {
/*  86 */     this.fetchHyperlinks = paramBoolean;
/*     */   }
/*     */   
/*     */   public String getText() {
/*  90 */     StringBuffer stringBuffer = new StringBuffer();
/*  91 */     XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy = this.document.getHeaderFooterPolicy();
/*     */ 
/*     */     
/*  94 */     extractHeaders(stringBuffer, xWPFHeaderFooterPolicy);
/*     */ 
/*     */     
/*  97 */     for (IBodyElement iBodyElement : this.document.getBodyElements()) {
/*  98 */       appendBodyElementText(stringBuffer, iBodyElement);
/*  99 */       stringBuffer.append('\n');
/*     */     } 
/*     */ 
/*     */     
/* 103 */     extractFooters(stringBuffer, xWPFHeaderFooterPolicy);
/*     */     
/* 105 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void appendBodyElementText(StringBuffer paramStringBuffer, IBodyElement paramIBodyElement) {
/* 109 */     if (paramIBodyElement instanceof XWPFParagraph) {
/* 110 */       appendParagraphText(paramStringBuffer, (XWPFParagraph)paramIBodyElement);
/* 111 */     } else if (paramIBodyElement instanceof XWPFTable) {
/* 112 */       appendTableText(paramStringBuffer, (XWPFTable)paramIBodyElement);
/* 113 */     } else if (paramIBodyElement instanceof XWPFSDT) {
/* 114 */       paramStringBuffer.append(((XWPFSDT)paramIBodyElement).getContent().getText());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void appendParagraphText(StringBuffer paramStringBuffer, XWPFParagraph paramXWPFParagraph) {
/* 119 */     CTSectPr cTSectPr = null;
/* 120 */     if (paramXWPFParagraph.getCTP().getPPr() != null) {
/* 121 */       cTSectPr = paramXWPFParagraph.getCTP().getPPr().getSectPr();
/*     */     }
/*     */     
/* 124 */     XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy = null;
/*     */     
/* 126 */     if (cTSectPr != null) {
/* 127 */       xWPFHeaderFooterPolicy = new XWPFHeaderFooterPolicy(this.document, cTSectPr);
/* 128 */       extractHeaders(paramStringBuffer, xWPFHeaderFooterPolicy);
/*     */     } 
/*     */ 
/*     */     
/* 132 */     for (IRunElement iRunElement : paramXWPFParagraph.getRuns()) {
/* 133 */       paramStringBuffer.append(iRunElement.toString());
/* 134 */       if (iRunElement instanceof XWPFHyperlinkRun && this.fetchHyperlinks) {
/* 135 */         XWPFHyperlink xWPFHyperlink = ((XWPFHyperlinkRun)iRunElement).getHyperlink(this.document);
/* 136 */         if (xWPFHyperlink != null) {
/* 137 */           paramStringBuffer.append(" <").append(xWPFHyperlink.getURL()).append(">");
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     XWPFCommentsDecorator xWPFCommentsDecorator = new XWPFCommentsDecorator(paramXWPFParagraph, null);
/* 143 */     String str1 = xWPFCommentsDecorator.getCommentText();
/* 144 */     if (str1.length() > 0) {
/* 145 */       paramStringBuffer.append(str1).append('\n');
/*     */     }
/*     */ 
/*     */     
/* 149 */     String str2 = paramXWPFParagraph.getFootnoteText();
/* 150 */     if (str2 != null && str2.length() > 0) {
/* 151 */       paramStringBuffer.append(str2).append('\n');
/*     */     }
/*     */     
/* 154 */     if (cTSectPr != null) {
/* 155 */       extractFooters(paramStringBuffer, xWPFHeaderFooterPolicy);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void appendTableText(StringBuffer paramStringBuffer, XWPFTable paramXWPFTable) {
/* 161 */     for (XWPFTableRow xWPFTableRow : paramXWPFTable.getRows()) {
/* 162 */       List<ICell> list = xWPFTableRow.getTableICells();
/* 163 */       for (byte b = 0; b < list.size(); b++) {
/* 164 */         ICell iCell = list.get(b);
/* 165 */         if (iCell instanceof XWPFTableCell) {
/* 166 */           paramStringBuffer.append(((XWPFTableCell)iCell).getTextRecursively());
/* 167 */         } else if (iCell instanceof XWPFSDTCell) {
/* 168 */           paramStringBuffer.append(((XWPFSDTCell)iCell).getContent().getText());
/*     */         } 
/* 170 */         if (b < list.size() - 1) {
/* 171 */           paramStringBuffer.append("\t");
/*     */         }
/*     */       } 
/* 174 */       paramStringBuffer.append('\n');
/*     */     } 
/*     */   }
/*     */   
/*     */   private void extractFooters(StringBuffer paramStringBuffer, XWPFHeaderFooterPolicy paramXWPFHeaderFooterPolicy) {
/* 179 */     if (paramXWPFHeaderFooterPolicy == null)
/*     */       return; 
/* 181 */     if (paramXWPFHeaderFooterPolicy.getFirstPageFooter() != null) {
/* 182 */       paramStringBuffer.append(paramXWPFHeaderFooterPolicy.getFirstPageFooter().getText());
/*     */     }
/* 184 */     if (paramXWPFHeaderFooterPolicy.getEvenPageFooter() != null) {
/* 185 */       paramStringBuffer.append(paramXWPFHeaderFooterPolicy.getEvenPageFooter().getText());
/*     */     }
/* 187 */     if (paramXWPFHeaderFooterPolicy.getDefaultFooter() != null) {
/* 188 */       paramStringBuffer.append(paramXWPFHeaderFooterPolicy.getDefaultFooter().getText());
/*     */     }
/*     */   }
/*     */   
/*     */   private void extractHeaders(StringBuffer paramStringBuffer, XWPFHeaderFooterPolicy paramXWPFHeaderFooterPolicy) {
/* 193 */     if (paramXWPFHeaderFooterPolicy == null)
/*     */       return; 
/* 195 */     if (paramXWPFHeaderFooterPolicy.getFirstPageHeader() != null) {
/* 196 */       paramStringBuffer.append(paramXWPFHeaderFooterPolicy.getFirstPageHeader().getText());
/*     */     }
/* 198 */     if (paramXWPFHeaderFooterPolicy.getEvenPageHeader() != null) {
/* 199 */       paramStringBuffer.append(paramXWPFHeaderFooterPolicy.getEvenPageHeader().getText());
/*     */     }
/* 201 */     if (paramXWPFHeaderFooterPolicy.getDefaultHeader() != null)
/* 202 */       paramStringBuffer.append(paramXWPFHeaderFooterPolicy.getDefaultHeader().getText()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwpf\extractor\XWPFWordExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */