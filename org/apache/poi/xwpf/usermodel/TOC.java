/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;
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
/*     */ public class TOC
/*     */ {
/*     */   CTSdtBlock block;
/*     */   
/*     */   public TOC() {
/*  48 */     this(CTSdtBlock.Factory.newInstance());
/*     */   }
/*     */   
/*     */   public TOC(CTSdtBlock paramCTSdtBlock) {
/*  52 */     this.block = paramCTSdtBlock;
/*  53 */     CTSdtPr cTSdtPr = paramCTSdtBlock.addNewSdtPr();
/*  54 */     CTDecimalNumber cTDecimalNumber = cTSdtPr.addNewId();
/*  55 */     cTDecimalNumber.setVal(new BigInteger("4844945"));
/*  56 */     cTSdtPr.addNewDocPartObj().addNewDocPartGallery().setVal("Table of contents");
/*  57 */     CTSdtEndPr cTSdtEndPr = paramCTSdtBlock.addNewSdtEndPr();
/*  58 */     CTRPr cTRPr = cTSdtEndPr.addNewRPr();
/*  59 */     CTFonts cTFonts = cTRPr.addNewRFonts();
/*  60 */     cTFonts.setAsciiTheme(STTheme.MINOR_H_ANSI);
/*  61 */     cTFonts.setEastAsiaTheme(STTheme.MINOR_H_ANSI);
/*  62 */     cTFonts.setHAnsiTheme(STTheme.MINOR_H_ANSI);
/*  63 */     cTFonts.setCstheme(STTheme.MINOR_BIDI);
/*  64 */     cTRPr.addNewB().setVal(STOnOff.OFF);
/*  65 */     cTRPr.addNewBCs().setVal(STOnOff.OFF);
/*  66 */     cTRPr.addNewColor().setVal("auto");
/*  67 */     cTRPr.addNewSz().setVal(new BigInteger("24"));
/*  68 */     cTRPr.addNewSzCs().setVal(new BigInteger("24"));
/*  69 */     CTSdtContentBlock cTSdtContentBlock = paramCTSdtBlock.addNewSdtContent();
/*  70 */     CTP cTP = cTSdtContentBlock.addNewP();
/*  71 */     cTP.setRsidR("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
/*  72 */     cTP.setRsidRDefault("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
/*  73 */     cTP.addNewPPr().addNewPStyle().setVal("TOCHeading");
/*  74 */     cTP.addNewR().addNewT().setStringValue("Table of Contents");
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTSdtBlock getBlock() {
/*  79 */     return this.block;
/*     */   }
/*     */   
/*     */   public void addRow(int paramInt1, String paramString1, int paramInt2, String paramString2) {
/*  83 */     CTSdtContentBlock cTSdtContentBlock = this.block.getSdtContent();
/*  84 */     CTP cTP = cTSdtContentBlock.addNewP();
/*  85 */     cTP.setRsidR("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
/*  86 */     cTP.setRsidRDefault("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
/*  87 */     CTPPr cTPPr = cTP.addNewPPr();
/*  88 */     cTPPr.addNewPStyle().setVal("TOC" + paramInt1);
/*  89 */     CTTabs cTTabs = cTPPr.addNewTabs();
/*  90 */     CTTabStop cTTabStop = cTTabs.addNewTab();
/*  91 */     cTTabStop.setVal(STTabJc.RIGHT);
/*  92 */     cTTabStop.setLeader(STTabTlc.DOT);
/*  93 */     cTTabStop.setPos(new BigInteger("8290"));
/*  94 */     cTPPr.addNewRPr().addNewNoProof();
/*  95 */     CTR cTR = cTP.addNewR();
/*  96 */     cTR.addNewRPr().addNewNoProof();
/*  97 */     cTR.addNewT().setStringValue(paramString1);
/*  98 */     cTR = cTP.addNewR();
/*  99 */     cTR.addNewRPr().addNewNoProof();
/* 100 */     cTR.addNewTab();
/* 101 */     cTR = cTP.addNewR();
/* 102 */     cTR.addNewRPr().addNewNoProof();
/* 103 */     cTR.addNewFldChar().setFldCharType(STFldCharType.BEGIN);
/*     */     
/* 105 */     cTR = cTP.addNewR();
/* 106 */     cTR.addNewRPr().addNewNoProof();
/* 107 */     CTText cTText = cTR.addNewInstrText();
/* 108 */     cTText.setSpace(SpaceAttribute.Space.PRESERVE);
/*     */     
/* 110 */     cTText.setStringValue(" PAGEREF _Toc" + paramString2 + " \\h ");
/* 111 */     cTP.addNewR().addNewRPr().addNewNoProof();
/* 112 */     cTR = cTP.addNewR();
/* 113 */     cTR.addNewRPr().addNewNoProof();
/* 114 */     cTR.addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
/*     */     
/* 116 */     cTR = cTP.addNewR();
/* 117 */     cTR.addNewRPr().addNewNoProof();
/* 118 */     cTR.addNewT().setStringValue(Integer.toString(paramInt2));
/* 119 */     cTR = cTP.addNewR();
/* 120 */     cTR.addNewRPr().addNewNoProof();
/* 121 */     cTR.addNewFldChar().setFldCharType(STFldCharType.END);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\TOC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */