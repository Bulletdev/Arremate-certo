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
/*     */ public final class WindowTwoRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 574;
/*  36 */   private static final BitField displayFormulas = BitFieldFactory.getInstance(1);
/*  37 */   private static final BitField displayGridlines = BitFieldFactory.getInstance(2);
/*  38 */   private static final BitField displayRowColHeadings = BitFieldFactory.getInstance(4);
/*  39 */   private static final BitField freezePanes = BitFieldFactory.getInstance(8);
/*  40 */   private static final BitField displayZeros = BitFieldFactory.getInstance(16);
/*     */   
/*  42 */   private static final BitField defaultHeader = BitFieldFactory.getInstance(32);
/*  43 */   private static final BitField arabic = BitFieldFactory.getInstance(64);
/*  44 */   private static final BitField displayGuts = BitFieldFactory.getInstance(128);
/*  45 */   private static final BitField freezePanesNoSplit = BitFieldFactory.getInstance(256);
/*  46 */   private static final BitField selected = BitFieldFactory.getInstance(512);
/*  47 */   private static final BitField active = BitFieldFactory.getInstance(1024);
/*  48 */   private static final BitField savedInPageBreakPreview = BitFieldFactory.getInstance(2048);
/*     */   
/*     */   private short field_1_options;
/*     */   
/*     */   private short field_2_top_row;
/*     */   
/*     */   private short field_3_left_col;
/*     */   
/*     */   private int field_4_header_color;
/*     */   
/*     */   private short field_5_page_break_zoom;
/*     */   
/*     */   private short field_6_normal_zoom;
/*     */   private int field_7_reserved;
/*     */   
/*     */   public WindowTwoRecord() {}
/*     */   
/*     */   public WindowTwoRecord(RecordInputStream paramRecordInputStream) {
/*  66 */     int i = paramRecordInputStream.remaining();
/*  67 */     this.field_1_options = paramRecordInputStream.readShort();
/*  68 */     this.field_2_top_row = paramRecordInputStream.readShort();
/*  69 */     this.field_3_left_col = paramRecordInputStream.readShort();
/*  70 */     this.field_4_header_color = paramRecordInputStream.readInt();
/*  71 */     if (i > 10) {
/*     */       
/*  73 */       this.field_5_page_break_zoom = paramRecordInputStream.readShort();
/*  74 */       this.field_6_normal_zoom = paramRecordInputStream.readShort();
/*     */     } 
/*  76 */     if (i > 14)
/*     */     {
/*  78 */       this.field_7_reserved = paramRecordInputStream.readInt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/*  89 */     this.field_1_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayFormulas(boolean paramBoolean) {
/* 101 */     this.field_1_options = displayFormulas.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayGridlines(boolean paramBoolean) {
/* 111 */     this.field_1_options = displayGridlines.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayRowColHeadings(boolean paramBoolean) {
/* 121 */     this.field_1_options = displayRowColHeadings.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFreezePanes(boolean paramBoolean) {
/* 131 */     this.field_1_options = freezePanes.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayZeros(boolean paramBoolean) {
/* 141 */     this.field_1_options = displayZeros.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultHeader(boolean paramBoolean) {
/* 151 */     this.field_1_options = defaultHeader.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArabic(boolean paramBoolean) {
/* 161 */     this.field_1_options = arabic.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayGuts(boolean paramBoolean) {
/* 171 */     this.field_1_options = displayGuts.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFreezePanesNoSplit(boolean paramBoolean) {
/* 181 */     this.field_1_options = freezePanesNoSplit.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelected(boolean paramBoolean) {
/* 191 */     this.field_1_options = selected.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActive(boolean paramBoolean) {
/* 199 */     this.field_1_options = active.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSavedInPageBreakPreview(boolean paramBoolean) {
/* 209 */     this.field_1_options = savedInPageBreakPreview.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopRow(short paramShort) {
/* 221 */     this.field_2_top_row = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftCol(short paramShort) {
/* 231 */     this.field_3_left_col = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaderColor(int paramInt) {
/* 241 */     this.field_4_header_color = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageBreakZoom(short paramShort) {
/* 251 */     this.field_5_page_break_zoom = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNormalZoom(short paramShort) {
/* 261 */     this.field_6_normal_zoom = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved(int paramInt) {
/* 270 */     this.field_7_reserved = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 280 */     return this.field_1_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayFormulas() {
/* 292 */     return displayFormulas.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayGridlines() {
/* 302 */     return displayGridlines.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayRowColHeadings() {
/* 312 */     return displayRowColHeadings.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFreezePanes() {
/* 322 */     return freezePanes.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayZeros() {
/* 332 */     return displayZeros.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDefaultHeader() {
/* 342 */     return defaultHeader.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getArabic() {
/* 352 */     return arabic.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayGuts() {
/* 362 */     return displayGuts.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFreezePanesNoSplit() {
/* 372 */     return freezePanesNoSplit.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSelected() {
/* 382 */     return selected.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isActive() {
/* 391 */     return active.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSavedInPageBreakPreview() {
/* 401 */     return savedInPageBreakPreview.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTopRow() {
/* 413 */     return this.field_2_top_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLeftCol() {
/* 423 */     return this.field_3_left_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeaderColor() {
/* 433 */     return this.field_4_header_color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPageBreakZoom() {
/* 443 */     return this.field_5_page_break_zoom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNormalZoom() {
/* 453 */     return this.field_6_normal_zoom;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved() {
/* 463 */     return this.field_7_reserved;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 468 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 470 */     stringBuffer.append("[WINDOW2]\n");
/* 471 */     stringBuffer.append("    .options        = ").append(Integer.toHexString(getOptions())).append("\n");
/*     */     
/* 473 */     stringBuffer.append("       .dispformulas= ").append(getDisplayFormulas()).append("\n");
/*     */     
/* 475 */     stringBuffer.append("       .dispgridlins= ").append(getDisplayGridlines()).append("\n");
/*     */     
/* 477 */     stringBuffer.append("       .disprcheadin= ").append(getDisplayRowColHeadings()).append("\n");
/*     */     
/* 479 */     stringBuffer.append("       .freezepanes = ").append(getFreezePanes()).append("\n");
/*     */     
/* 481 */     stringBuffer.append("       .displayzeros= ").append(getDisplayZeros()).append("\n");
/*     */     
/* 483 */     stringBuffer.append("       .defaultheadr= ").append(getDefaultHeader()).append("\n");
/*     */     
/* 485 */     stringBuffer.append("       .arabic      = ").append(getArabic()).append("\n");
/*     */     
/* 487 */     stringBuffer.append("       .displayguts = ").append(getDisplayGuts()).append("\n");
/*     */     
/* 489 */     stringBuffer.append("       .frzpnsnosplt= ").append(getFreezePanesNoSplit()).append("\n");
/*     */     
/* 491 */     stringBuffer.append("       .selected    = ").append(getSelected()).append("\n");
/*     */     
/* 493 */     stringBuffer.append("       .active       = ").append(isActive()).append("\n");
/*     */     
/* 495 */     stringBuffer.append("       .svdinpgbrkpv= ").append(getSavedInPageBreakPreview()).append("\n");
/*     */     
/* 497 */     stringBuffer.append("    .toprow         = ").append(Integer.toHexString(getTopRow())).append("\n");
/*     */     
/* 499 */     stringBuffer.append("    .leftcol        = ").append(Integer.toHexString(getLeftCol())).append("\n");
/*     */     
/* 501 */     stringBuffer.append("    .headercolor    = ").append(Integer.toHexString(getHeaderColor())).append("\n");
/*     */     
/* 503 */     stringBuffer.append("    .pagebreakzoom  = ").append(Integer.toHexString(getPageBreakZoom())).append("\n");
/*     */     
/* 505 */     stringBuffer.append("    .normalzoom     = ").append(Integer.toHexString(getNormalZoom())).append("\n");
/*     */     
/* 507 */     stringBuffer.append("    .reserved       = ").append(Integer.toHexString(getReserved())).append("\n");
/*     */     
/* 509 */     stringBuffer.append("[/WINDOW2]\n");
/* 510 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 514 */     paramLittleEndianOutput.writeShort(getOptions());
/* 515 */     paramLittleEndianOutput.writeShort(getTopRow());
/* 516 */     paramLittleEndianOutput.writeShort(getLeftCol());
/* 517 */     paramLittleEndianOutput.writeInt(getHeaderColor());
/* 518 */     paramLittleEndianOutput.writeShort(getPageBreakZoom());
/* 519 */     paramLittleEndianOutput.writeShort(getNormalZoom());
/* 520 */     paramLittleEndianOutput.writeInt(getReserved());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 524 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 529 */     return 574;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 533 */     WindowTwoRecord windowTwoRecord = new WindowTwoRecord();
/* 534 */     windowTwoRecord.field_1_options = this.field_1_options;
/* 535 */     windowTwoRecord.field_2_top_row = this.field_2_top_row;
/* 536 */     windowTwoRecord.field_3_left_col = this.field_3_left_col;
/* 537 */     windowTwoRecord.field_4_header_color = this.field_4_header_color;
/* 538 */     windowTwoRecord.field_5_page_break_zoom = this.field_5_page_break_zoom;
/* 539 */     windowTwoRecord.field_6_normal_zoom = this.field_6_normal_zoom;
/* 540 */     windowTwoRecord.field_7_reserved = this.field_7_reserved;
/* 541 */     return windowTwoRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\WindowTwoRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */