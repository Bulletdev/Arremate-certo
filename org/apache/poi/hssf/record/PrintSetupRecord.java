/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ public final class PrintSetupRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 161;
/*     */   private short field_1_paper_size;
/*     */   private short field_2_scale;
/*     */   private short field_3_page_start;
/*     */   private short field_4_fit_width;
/*     */   private short field_5_fit_height;
/*     */   private short field_6_options;
/*  42 */   private static final BitField lefttoright = BitFieldFactory.getInstance(1);
/*     */   
/*  44 */   private static final BitField landscape = BitFieldFactory.getInstance(2);
/*     */   
/*  46 */   private static final BitField validsettings = BitFieldFactory.getInstance(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private static final BitField nocolor = BitFieldFactory.getInstance(8);
/*     */   
/*  53 */   private static final BitField draft = BitFieldFactory.getInstance(16);
/*     */   
/*  55 */   private static final BitField notes = BitFieldFactory.getInstance(32);
/*     */   
/*  57 */   private static final BitField noOrientation = BitFieldFactory.getInstance(64);
/*     */   
/*  59 */   private static final BitField usepage = BitFieldFactory.getInstance(128);
/*     */   
/*     */   private short field_7_hresolution;
/*     */   
/*     */   private short field_8_vresolution;
/*     */   
/*     */   private double field_9_headermargin;
/*     */   
/*     */   private double field_10_footermargin;
/*     */   private short field_11_copies;
/*     */   
/*     */   public PrintSetupRecord() {}
/*     */   
/*     */   public PrintSetupRecord(RecordInputStream paramRecordInputStream) {
/*  73 */     this.field_1_paper_size = paramRecordInputStream.readShort();
/*  74 */     this.field_2_scale = paramRecordInputStream.readShort();
/*  75 */     this.field_3_page_start = paramRecordInputStream.readShort();
/*  76 */     this.field_4_fit_width = paramRecordInputStream.readShort();
/*  77 */     this.field_5_fit_height = paramRecordInputStream.readShort();
/*  78 */     this.field_6_options = paramRecordInputStream.readShort();
/*  79 */     this.field_7_hresolution = paramRecordInputStream.readShort();
/*  80 */     this.field_8_vresolution = paramRecordInputStream.readShort();
/*  81 */     this.field_9_headermargin = paramRecordInputStream.readDouble();
/*  82 */     this.field_10_footermargin = paramRecordInputStream.readDouble();
/*  83 */     this.field_11_copies = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPaperSize(short paramShort) {
/*  88 */     this.field_1_paper_size = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScale(short paramShort) {
/*  93 */     this.field_2_scale = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPageStart(short paramShort) {
/*  98 */     this.field_3_page_start = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFitWidth(short paramShort) {
/* 103 */     this.field_4_fit_width = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFitHeight(short paramShort) {
/* 108 */     this.field_5_fit_height = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 113 */     this.field_6_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftToRight(boolean paramBoolean) {
/* 119 */     this.field_6_options = lefttoright.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLandscape(boolean paramBoolean) {
/* 124 */     this.field_6_options = landscape.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValidSettings(boolean paramBoolean) {
/* 129 */     this.field_6_options = validsettings.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNoColor(boolean paramBoolean) {
/* 134 */     this.field_6_options = nocolor.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDraft(boolean paramBoolean) {
/* 139 */     this.field_6_options = draft.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNotes(boolean paramBoolean) {
/* 144 */     this.field_6_options = notes.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNoOrientation(boolean paramBoolean) {
/* 149 */     this.field_6_options = noOrientation.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUsePage(boolean paramBoolean) {
/* 154 */     this.field_6_options = usepage.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHResolution(short paramShort) {
/* 160 */     this.field_7_hresolution = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVResolution(short paramShort) {
/* 165 */     this.field_8_vresolution = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeaderMargin(double paramDouble) {
/* 170 */     this.field_9_headermargin = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFooterMargin(double paramDouble) {
/* 175 */     this.field_10_footermargin = paramDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCopies(short paramShort) {
/* 180 */     this.field_11_copies = paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getPaperSize() {
/* 185 */     return this.field_1_paper_size;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getScale() {
/* 190 */     return this.field_2_scale;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getPageStart() {
/* 195 */     return this.field_3_page_start;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getFitWidth() {
/* 200 */     return this.field_4_fit_width;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getFitHeight() {
/* 205 */     return this.field_5_fit_height;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 210 */     return this.field_6_options;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLeftToRight() {
/* 216 */     return lefttoright.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getLandscape() {
/* 221 */     return landscape.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getValidSettings() {
/* 226 */     return validsettings.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getNoColor() {
/* 231 */     return nocolor.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDraft() {
/* 236 */     return draft.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getNotes() {
/* 241 */     return notes.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getNoOrientation() {
/* 246 */     return noOrientation.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getUsePage() {
/* 251 */     return usepage.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHResolution() {
/* 257 */     return this.field_7_hresolution;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getVResolution() {
/* 262 */     return this.field_8_vresolution;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getHeaderMargin() {
/* 267 */     return this.field_9_headermargin;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getFooterMargin() {
/* 272 */     return this.field_10_footermargin;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getCopies() {
/* 277 */     return this.field_11_copies;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 282 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 284 */     stringBuffer.append("[PRINTSETUP]\n");
/* 285 */     stringBuffer.append("    .papersize      = ").append(getPaperSize()).append("\n");
/*     */     
/* 287 */     stringBuffer.append("    .scale          = ").append(getScale()).append("\n");
/*     */     
/* 289 */     stringBuffer.append("    .pagestart      = ").append(getPageStart()).append("\n");
/*     */     
/* 291 */     stringBuffer.append("    .fitwidth       = ").append(getFitWidth()).append("\n");
/*     */     
/* 293 */     stringBuffer.append("    .fitheight      = ").append(getFitHeight()).append("\n");
/*     */     
/* 295 */     stringBuffer.append("    .options        = ").append(getOptions()).append("\n");
/*     */     
/* 297 */     stringBuffer.append("        .ltor       = ").append(getLeftToRight()).append("\n");
/*     */     
/* 299 */     stringBuffer.append("        .landscape  = ").append(getLandscape()).append("\n");
/*     */     
/* 301 */     stringBuffer.append("        .valid      = ").append(getValidSettings()).append("\n");
/*     */     
/* 303 */     stringBuffer.append("        .mono       = ").append(getNoColor()).append("\n");
/*     */     
/* 305 */     stringBuffer.append("        .draft      = ").append(getDraft()).append("\n");
/*     */     
/* 307 */     stringBuffer.append("        .notes      = ").append(getNotes()).append("\n");
/*     */     
/* 309 */     stringBuffer.append("        .noOrientat = ").append(getNoOrientation()).append("\n");
/*     */     
/* 311 */     stringBuffer.append("        .usepage    = ").append(getUsePage()).append("\n");
/*     */     
/* 313 */     stringBuffer.append("    .hresolution    = ").append(getHResolution()).append("\n");
/*     */     
/* 315 */     stringBuffer.append("    .vresolution    = ").append(getVResolution()).append("\n");
/*     */     
/* 317 */     stringBuffer.append("    .headermargin   = ").append(getHeaderMargin()).append("\n");
/*     */     
/* 319 */     stringBuffer.append("    .footermargin   = ").append(getFooterMargin()).append("\n");
/*     */     
/* 321 */     stringBuffer.append("    .copies         = ").append(getCopies()).append("\n");
/*     */     
/* 323 */     stringBuffer.append("[/PRINTSETUP]\n");
/* 324 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 328 */     paramLittleEndianOutput.writeShort(getPaperSize());
/* 329 */     paramLittleEndianOutput.writeShort(getScale());
/* 330 */     paramLittleEndianOutput.writeShort(getPageStart());
/* 331 */     paramLittleEndianOutput.writeShort(getFitWidth());
/* 332 */     paramLittleEndianOutput.writeShort(getFitHeight());
/* 333 */     paramLittleEndianOutput.writeShort(getOptions());
/* 334 */     paramLittleEndianOutput.writeShort(getHResolution());
/* 335 */     paramLittleEndianOutput.writeShort(getVResolution());
/* 336 */     paramLittleEndianOutput.writeDouble(getHeaderMargin());
/* 337 */     paramLittleEndianOutput.writeDouble(getFooterMargin());
/* 338 */     paramLittleEndianOutput.writeShort(getCopies());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 342 */     return 34;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 347 */     return 161;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 351 */     PrintSetupRecord printSetupRecord = new PrintSetupRecord();
/* 352 */     printSetupRecord.field_1_paper_size = this.field_1_paper_size;
/* 353 */     printSetupRecord.field_2_scale = this.field_2_scale;
/* 354 */     printSetupRecord.field_3_page_start = this.field_3_page_start;
/* 355 */     printSetupRecord.field_4_fit_width = this.field_4_fit_width;
/* 356 */     printSetupRecord.field_5_fit_height = this.field_5_fit_height;
/* 357 */     printSetupRecord.field_6_options = this.field_6_options;
/* 358 */     printSetupRecord.field_7_hresolution = this.field_7_hresolution;
/* 359 */     printSetupRecord.field_8_vresolution = this.field_8_vresolution;
/* 360 */     printSetupRecord.field_9_headermargin = this.field_9_headermargin;
/* 361 */     printSetupRecord.field_10_footermargin = this.field_10_footermargin;
/* 362 */     printSetupRecord.field_11_copies = this.field_11_copies;
/* 363 */     return printSetupRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PrintSetupRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */