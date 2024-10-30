/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XWPFSDTContent
/*     */   implements ISDTContent
/*     */ {
/*  43 */   private List<XWPFParagraph> paragraphs = new ArrayList<XWPFParagraph>();
/*  44 */   private List<XWPFTable> tables = new ArrayList<XWPFTable>();
/*  45 */   private List<XWPFRun> runs = new ArrayList<XWPFRun>();
/*  46 */   private List<XWPFSDT> contentControls = new ArrayList<XWPFSDT>();
/*  47 */   private List<ISDTContents> bodyElements = new ArrayList<ISDTContents>();
/*     */   
/*     */   public XWPFSDTContent(CTSdtContentRun paramCTSdtContentRun, IBody paramIBody, IRunBody paramIRunBody) {
/*  50 */     for (CTR cTR : paramCTSdtContentRun.getRArray()) {
/*  51 */       XWPFRun xWPFRun = new XWPFRun(cTR, paramIRunBody);
/*  52 */       this.runs.add(xWPFRun);
/*  53 */       this.bodyElements.add(xWPFRun);
/*     */     } 
/*     */   }
/*     */   
/*     */   public XWPFSDTContent(CTSdtContentBlock paramCTSdtContentBlock, IBody paramIBody, IRunBody paramIRunBody) {
/*  58 */     XmlCursor xmlCursor = paramCTSdtContentBlock.newCursor();
/*  59 */     xmlCursor.selectPath("./*");
/*  60 */     while (xmlCursor.toNextSelection()) {
/*  61 */       XmlObject xmlObject = xmlCursor.getObject();
/*  62 */       if (xmlObject instanceof CTP) {
/*  63 */         XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, paramIBody);
/*  64 */         this.bodyElements.add(xWPFParagraph);
/*  65 */         this.paragraphs.add(xWPFParagraph); continue;
/*  66 */       }  if (xmlObject instanceof CTTbl) {
/*  67 */         XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, paramIBody);
/*  68 */         this.bodyElements.add(xWPFTable);
/*  69 */         this.tables.add(xWPFTable); continue;
/*  70 */       }  if (xmlObject instanceof CTSdtBlock) {
/*  71 */         XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, paramIBody);
/*  72 */         this.bodyElements.add(xWPFSDT);
/*  73 */         this.contentControls.add(xWPFSDT); continue;
/*  74 */       }  if (xmlObject instanceof CTR) {
/*  75 */         XWPFRun xWPFRun = new XWPFRun((CTR)xmlObject, paramIRunBody);
/*  76 */         this.runs.add(xWPFRun);
/*  77 */         this.bodyElements.add(xWPFRun);
/*     */       } 
/*     */     } 
/*  80 */     xmlCursor.dispose();
/*     */   }
/*     */   
/*     */   public String getText() {
/*  84 */     StringBuilder stringBuilder = new StringBuilder();
/*  85 */     boolean bool = false;
/*  86 */     for (byte b = 0; b < this.bodyElements.size(); b++) {
/*  87 */       XWPFParagraph xWPFParagraph = (XWPFParagraph)this.bodyElements.get(b);
/*  88 */       if (xWPFParagraph instanceof XWPFParagraph) {
/*  89 */         appendParagraph(xWPFParagraph, stringBuilder);
/*  90 */         bool = true;
/*  91 */       } else if (xWPFParagraph instanceof XWPFTable) {
/*  92 */         appendTable((XWPFTable)xWPFParagraph, stringBuilder);
/*  93 */         bool = true;
/*  94 */       } else if (xWPFParagraph instanceof XWPFSDT) {
/*  95 */         stringBuilder.append(((XWPFSDT)xWPFParagraph).getContent().getText());
/*  96 */         bool = true;
/*  97 */       } else if (xWPFParagraph instanceof XWPFRun) {
/*  98 */         stringBuilder.append(((XWPFRun)xWPFParagraph).toString());
/*  99 */         bool = false;
/*     */       } 
/* 101 */       if (bool == true && b < this.bodyElements.size() - 1) {
/* 102 */         stringBuilder.append("\n");
/*     */       }
/*     */     } 
/* 105 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void appendTable(XWPFTable paramXWPFTable, StringBuilder paramStringBuilder) {
/* 110 */     for (XWPFTableRow xWPFTableRow : paramXWPFTable.getRows()) {
/* 111 */       List<ICell> list = xWPFTableRow.getTableICells();
/* 112 */       for (byte b = 0; b < list.size(); b++) {
/* 113 */         ICell iCell = list.get(b);
/* 114 */         if (iCell instanceof XWPFTableCell) {
/* 115 */           paramStringBuilder.append(((XWPFTableCell)iCell).getTextRecursively());
/* 116 */         } else if (iCell instanceof XWPFSDTCell) {
/* 117 */           paramStringBuilder.append(((XWPFSDTCell)iCell).getContent().getText());
/*     */         } 
/* 119 */         if (b < list.size() - 1) {
/* 120 */           paramStringBuilder.append("\t");
/*     */         }
/*     */       } 
/* 123 */       paramStringBuilder.append('\n');
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendParagraph(XWPFParagraph paramXWPFParagraph, StringBuilder paramStringBuilder) {
/* 128 */     for (IRunElement iRunElement : paramXWPFParagraph.getRuns()) {
/* 129 */       paramStringBuilder.append(iRunElement.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     return getText();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFSDTContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */