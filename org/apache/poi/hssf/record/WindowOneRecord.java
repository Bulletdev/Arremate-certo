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
/*     */ 
/*     */ public final class WindowOneRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 61;
/*     */   private short field_1_h_hold;
/*     */   private short field_2_v_hold;
/*     */   private short field_3_width;
/*     */   private short field_4_height;
/*     */   private short field_5_options;
/*  42 */   private static final BitField hidden = BitFieldFactory.getInstance(1);
/*     */   
/*  44 */   private static final BitField iconic = BitFieldFactory.getInstance(2);
/*     */   
/*  46 */   private static final BitField reserved = BitFieldFactory.getInstance(4);
/*  47 */   private static final BitField hscroll = BitFieldFactory.getInstance(8);
/*     */   
/*  49 */   private static final BitField vscroll = BitFieldFactory.getInstance(16);
/*     */   
/*  51 */   private static final BitField tabs = BitFieldFactory.getInstance(32);
/*     */   
/*     */   private int field_6_active_sheet;
/*     */   
/*     */   private int field_7_first_visible_tab;
/*     */   
/*     */   private short field_8_num_selected_tabs;
/*     */   
/*     */   private short field_9_tab_width_ratio;
/*     */ 
/*     */   
/*     */   public WindowOneRecord() {}
/*     */ 
/*     */   
/*     */   public WindowOneRecord(RecordInputStream paramRecordInputStream) {
/*  66 */     this.field_1_h_hold = paramRecordInputStream.readShort();
/*  67 */     this.field_2_v_hold = paramRecordInputStream.readShort();
/*  68 */     this.field_3_width = paramRecordInputStream.readShort();
/*  69 */     this.field_4_height = paramRecordInputStream.readShort();
/*  70 */     this.field_5_options = paramRecordInputStream.readShort();
/*  71 */     this.field_6_active_sheet = paramRecordInputStream.readShort();
/*  72 */     this.field_7_first_visible_tab = paramRecordInputStream.readShort();
/*  73 */     this.field_8_num_selected_tabs = paramRecordInputStream.readShort();
/*  74 */     this.field_9_tab_width_ratio = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalHold(short paramShort) {
/*  84 */     this.field_1_h_hold = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalHold(short paramShort) {
/*  94 */     this.field_2_v_hold = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWidth(short paramShort) {
/* 104 */     this.field_3_width = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeight(short paramShort) {
/* 114 */     this.field_4_height = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 125 */     this.field_5_options = paramShort;
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
/*     */   public void setHidden(boolean paramBoolean) {
/* 137 */     this.field_5_options = hidden.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIconic(boolean paramBoolean) {
/* 147 */     this.field_5_options = iconic.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayHorizonalScrollbar(boolean paramBoolean) {
/* 157 */     this.field_5_options = hscroll.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayVerticalScrollbar(boolean paramBoolean) {
/* 167 */     this.field_5_options = vscroll.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayTabs(boolean paramBoolean) {
/* 177 */     this.field_5_options = tabs.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActiveSheetIndex(int paramInt) {
/* 183 */     this.field_6_active_sheet = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstVisibleTab(int paramInt) {
/* 192 */     this.field_7_first_visible_tab = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumSelectedTabs(short paramShort) {
/* 202 */     this.field_8_num_selected_tabs = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTabWidthRatio(short paramShort) {
/* 212 */     this.field_9_tab_width_ratio = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHorizontalHold() {
/* 222 */     return this.field_1_h_hold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVerticalHold() {
/* 232 */     return this.field_2_v_hold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getWidth() {
/* 242 */     return this.field_3_width;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHeight() {
/* 252 */     return this.field_4_height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 263 */     return this.field_5_options;
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
/*     */   public boolean getHidden() {
/* 275 */     return hidden.isSet(this.field_5_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIconic() {
/* 285 */     return iconic.isSet(this.field_5_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayHorizontalScrollbar() {
/* 295 */     return hscroll.isSet(this.field_5_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayVerticalScrollbar() {
/* 305 */     return vscroll.isSet(this.field_5_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayTabs() {
/* 315 */     return tabs.isSet(this.field_5_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActiveSheetIndex() {
/* 325 */     return this.field_6_active_sheet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstVisibleTab() {
/* 333 */     return this.field_7_first_visible_tab;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumSelectedTabs() {
/* 343 */     return this.field_8_num_selected_tabs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTabWidthRatio() {
/* 353 */     return this.field_9_tab_width_ratio;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 358 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 360 */     stringBuffer.append("[WINDOW1]\n");
/* 361 */     stringBuffer.append("    .h_hold          = ").append(Integer.toHexString(getHorizontalHold())).append("\n");
/*     */     
/* 363 */     stringBuffer.append("    .v_hold          = ").append(Integer.toHexString(getVerticalHold())).append("\n");
/*     */     
/* 365 */     stringBuffer.append("    .width           = ").append(Integer.toHexString(getWidth())).append("\n");
/*     */     
/* 367 */     stringBuffer.append("    .height          = ").append(Integer.toHexString(getHeight())).append("\n");
/*     */     
/* 369 */     stringBuffer.append("    .options         = ").append(Integer.toHexString(getOptions())).append("\n");
/*     */     
/* 371 */     stringBuffer.append("        .hidden      = ").append(getHidden()).append("\n");
/*     */     
/* 373 */     stringBuffer.append("        .iconic      = ").append(getIconic()).append("\n");
/*     */     
/* 375 */     stringBuffer.append("        .hscroll     = ").append(getDisplayHorizontalScrollbar()).append("\n");
/*     */     
/* 377 */     stringBuffer.append("        .vscroll     = ").append(getDisplayVerticalScrollbar()).append("\n");
/*     */     
/* 379 */     stringBuffer.append("        .tabs        = ").append(getDisplayTabs()).append("\n");
/*     */     
/* 381 */     stringBuffer.append("    .activeSheet     = ").append(Integer.toHexString(getActiveSheetIndex())).append("\n");
/*     */     
/* 383 */     stringBuffer.append("    .firstVisibleTab    = ").append(Integer.toHexString(getFirstVisibleTab())).append("\n");
/*     */     
/* 385 */     stringBuffer.append("    .numselectedtabs = ").append(Integer.toHexString(getNumSelectedTabs())).append("\n");
/*     */     
/* 387 */     stringBuffer.append("    .tabwidthratio   = ").append(Integer.toHexString(getTabWidthRatio())).append("\n");
/*     */     
/* 389 */     stringBuffer.append("[/WINDOW1]\n");
/* 390 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 394 */     paramLittleEndianOutput.writeShort(getHorizontalHold());
/* 395 */     paramLittleEndianOutput.writeShort(getVerticalHold());
/* 396 */     paramLittleEndianOutput.writeShort(getWidth());
/* 397 */     paramLittleEndianOutput.writeShort(getHeight());
/* 398 */     paramLittleEndianOutput.writeShort(getOptions());
/* 399 */     paramLittleEndianOutput.writeShort(getActiveSheetIndex());
/* 400 */     paramLittleEndianOutput.writeShort(getFirstVisibleTab());
/* 401 */     paramLittleEndianOutput.writeShort(getNumSelectedTabs());
/* 402 */     paramLittleEndianOutput.writeShort(getTabWidthRatio());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 406 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 411 */     return 61;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\WindowOneRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */