/*      */ package org.apache.poi.hssf.record;
/*      */ 
/*      */ import org.apache.poi.util.BitField;
/*      */ import org.apache.poi.util.BitFieldFactory;
/*      */ import org.apache.poi.util.LittleEndianOutput;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ExtendedFormatRecord
/*      */   extends StandardRecord
/*      */ {
/*      */   public static final short sid = 224;
/*      */   public static final short NULL = -16;
/*      */   public static final short XF_STYLE = 1;
/*      */   public static final short XF_CELL = 0;
/*      */   public static final short NONE = 0;
/*      */   public static final short THIN = 1;
/*      */   public static final short MEDIUM = 2;
/*      */   public static final short DASHED = 3;
/*      */   public static final short DOTTED = 4;
/*      */   public static final short THICK = 5;
/*      */   public static final short DOUBLE = 6;
/*      */   public static final short HAIR = 7;
/*      */   public static final short MEDIUM_DASHED = 8;
/*      */   public static final short DASH_DOT = 9;
/*      */   public static final short MEDIUM_DASH_DOT = 10;
/*      */   public static final short DASH_DOT_DOT = 11;
/*      */   public static final short MEDIUM_DASH_DOT_DOT = 12;
/*      */   public static final short SLANTED_DASH_DOT = 13;
/*      */   public static final short GENERAL = 0;
/*      */   public static final short LEFT = 1;
/*      */   public static final short CENTER = 2;
/*      */   public static final short RIGHT = 3;
/*      */   public static final short FILL = 4;
/*      */   public static final short JUSTIFY = 5;
/*      */   public static final short CENTER_SELECTION = 6;
/*      */   public static final short VERTICAL_TOP = 0;
/*      */   public static final short VERTICAL_CENTER = 1;
/*      */   public static final short VERTICAL_BOTTOM = 2;
/*      */   public static final short VERTICAL_JUSTIFY = 3;
/*      */   public static final short NO_FILL = 0;
/*      */   public static final short SOLID_FILL = 1;
/*      */   public static final short FINE_DOTS = 2;
/*      */   public static final short ALT_BARS = 3;
/*      */   public static final short SPARSE_DOTS = 4;
/*      */   public static final short THICK_HORZ_BANDS = 5;
/*      */   public static final short THICK_VERT_BANDS = 6;
/*      */   public static final short THICK_BACKWARD_DIAG = 7;
/*      */   public static final short THICK_FORWARD_DIAG = 8;
/*      */   public static final short BIG_SPOTS = 9;
/*      */   public static final short BRICKS = 10;
/*      */   public static final short THIN_HORZ_BANDS = 11;
/*      */   public static final short THIN_VERT_BANDS = 12;
/*      */   public static final short THIN_BACKWARD_DIAG = 13;
/*      */   public static final short THIN_FORWARD_DIAG = 14;
/*      */   public static final short SQUARES = 15;
/*      */   public static final short DIAMONDS = 16;
/*      */   private short field_1_font_index;
/*      */   private short field_2_format_index;
/*  108 */   private static final BitField _locked = BitFieldFactory.getInstance(1);
/*  109 */   private static final BitField _hidden = BitFieldFactory.getInstance(2);
/*  110 */   private static final BitField _xf_type = BitFieldFactory.getInstance(4);
/*  111 */   private static final BitField _123_prefix = BitFieldFactory.getInstance(8);
/*  112 */   private static final BitField _parent_index = BitFieldFactory.getInstance(65520);
/*      */   
/*      */   private short field_3_cell_options;
/*      */   
/*  116 */   private static final BitField _alignment = BitFieldFactory.getInstance(7);
/*  117 */   private static final BitField _wrap_text = BitFieldFactory.getInstance(8);
/*  118 */   private static final BitField _vertical_alignment = BitFieldFactory.getInstance(112);
/*  119 */   private static final BitField _justify_last = BitFieldFactory.getInstance(128);
/*  120 */   private static final BitField _rotation = BitFieldFactory.getInstance(65280);
/*      */   
/*      */   private short field_4_alignment_options;
/*      */   
/*  124 */   private static final BitField _indent = BitFieldFactory.getInstance(15);
/*      */   
/*  126 */   private static final BitField _shrink_to_fit = BitFieldFactory.getInstance(16);
/*      */   
/*  128 */   private static final BitField _merge_cells = BitFieldFactory.getInstance(32);
/*      */   
/*  130 */   private static final BitField _reading_order = BitFieldFactory.getInstance(192);
/*      */ 
/*      */ 
/*      */   
/*  134 */   private static final BitField _indent_not_parent_format = BitFieldFactory.getInstance(1024);
/*      */   
/*  136 */   private static final BitField _indent_not_parent_font = BitFieldFactory.getInstance(2048);
/*      */   
/*  138 */   private static final BitField _indent_not_parent_alignment = BitFieldFactory.getInstance(4096);
/*      */   
/*  140 */   private static final BitField _indent_not_parent_border = BitFieldFactory.getInstance(8192);
/*      */   
/*  142 */   private static final BitField _indent_not_parent_pattern = BitFieldFactory.getInstance(16384);
/*      */   
/*  144 */   private static final BitField _indent_not_parent_cell_options = BitFieldFactory.getInstance(32768);
/*      */ 
/*      */   
/*      */   private short field_5_indention_options;
/*      */   
/*  149 */   private static final BitField _border_left = BitFieldFactory.getInstance(15);
/*  150 */   private static final BitField _border_right = BitFieldFactory.getInstance(240);
/*  151 */   private static final BitField _border_top = BitFieldFactory.getInstance(3840);
/*  152 */   private static final BitField _border_bottom = BitFieldFactory.getInstance(61440);
/*      */ 
/*      */   
/*      */   private short field_6_border_options;
/*      */   
/*  157 */   private static final BitField _left_border_palette_idx = BitFieldFactory.getInstance(127);
/*      */   
/*  159 */   private static final BitField _right_border_palette_idx = BitFieldFactory.getInstance(16256);
/*      */   
/*  161 */   private static final BitField _diag = BitFieldFactory.getInstance(49152);
/*      */ 
/*      */   
/*      */   private short field_7_palette_options;
/*      */   
/*  166 */   private static final BitField _top_border_palette_idx = BitFieldFactory.getInstance(127);
/*      */   
/*  168 */   private static final BitField _bottom_border_palette_idx = BitFieldFactory.getInstance(16256);
/*      */   
/*  170 */   private static final BitField _adtl_diag = BitFieldFactory.getInstance(2080768);
/*      */   
/*  172 */   private static final BitField _adtl_diag_line_style = BitFieldFactory.getInstance(31457280);
/*      */ 
/*      */ 
/*      */   
/*  176 */   private static final BitField _adtl_fill_pattern = BitFieldFactory.getInstance(-67108864);
/*      */ 
/*      */   
/*      */   private int field_8_adtl_palette_options;
/*      */   
/*  181 */   private static final BitField _fill_foreground = BitFieldFactory.getInstance(127);
/*  182 */   private static final BitField _fill_background = BitFieldFactory.getInstance(16256);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private short field_9_fill_palette_options;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExtendedFormatRecord() {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExtendedFormatRecord(RecordInputStream paramRecordInputStream) {
/*  199 */     this.field_1_font_index = paramRecordInputStream.readShort();
/*  200 */     this.field_2_format_index = paramRecordInputStream.readShort();
/*  201 */     this.field_3_cell_options = paramRecordInputStream.readShort();
/*  202 */     this.field_4_alignment_options = paramRecordInputStream.readShort();
/*  203 */     this.field_5_indention_options = paramRecordInputStream.readShort();
/*  204 */     this.field_6_border_options = paramRecordInputStream.readShort();
/*  205 */     this.field_7_palette_options = paramRecordInputStream.readShort();
/*  206 */     this.field_8_adtl_palette_options = paramRecordInputStream.readInt();
/*  207 */     this.field_9_fill_palette_options = paramRecordInputStream.readShort();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFontIndex(short paramShort) {
/*  220 */     this.field_1_font_index = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFormatIndex(short paramShort) {
/*  233 */     this.field_2_format_index = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellOptions(short paramShort) {
/*  247 */     this.field_3_cell_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLocked(boolean paramBoolean) {
/*  262 */     this.field_3_cell_options = _locked.setShortBoolean(this.field_3_cell_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHidden(boolean paramBoolean) {
/*  276 */     this.field_3_cell_options = _hidden.setShortBoolean(this.field_3_cell_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setXFType(short paramShort) {
/*  292 */     this.field_3_cell_options = _xf_type.setShortValue(this.field_3_cell_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set123Prefix(boolean paramBoolean) {
/*  306 */     this.field_3_cell_options = _123_prefix.setShortBoolean(this.field_3_cell_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setParentIndex(short paramShort) {
/*  323 */     this.field_3_cell_options = _parent_index.setShortValue(this.field_3_cell_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlignmentOptions(short paramShort) {
/*  339 */     this.field_4_alignment_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlignment(short paramShort) {
/*  359 */     this.field_4_alignment_options = _alignment.setShortValue(this.field_4_alignment_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWrapText(boolean paramBoolean) {
/*  373 */     this.field_4_alignment_options = _wrap_text.setShortBoolean(this.field_4_alignment_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVerticalAlignment(short paramShort) {
/*  392 */     this.field_4_alignment_options = _vertical_alignment.setShortValue(this.field_4_alignment_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setJustifyLast(short paramShort) {
/*  407 */     this.field_4_alignment_options = _justify_last.setShortValue(this.field_4_alignment_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRotation(short paramShort) {
/*  421 */     this.field_4_alignment_options = _rotation.setShortValue(this.field_4_alignment_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentionOptions(short paramShort) {
/*  436 */     this.field_5_indention_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndent(short paramShort) {
/*  450 */     this.field_5_indention_options = _indent.setShortValue(this.field_5_indention_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShrinkToFit(boolean paramBoolean) {
/*  464 */     this.field_5_indention_options = _shrink_to_fit.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMergeCells(boolean paramBoolean) {
/*  478 */     this.field_5_indention_options = _merge_cells.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReadingOrder(short paramShort) {
/*  492 */     this.field_5_indention_options = _reading_order.setShortValue(this.field_5_indention_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentNotParentFormat(boolean paramBoolean) {
/*  507 */     this.field_5_indention_options = _indent_not_parent_format.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentNotParentFont(boolean paramBoolean) {
/*  523 */     this.field_5_indention_options = _indent_not_parent_font.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentNotParentAlignment(boolean paramBoolean) {
/*  539 */     this.field_5_indention_options = _indent_not_parent_alignment.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentNotParentBorder(boolean paramBoolean) {
/*  555 */     this.field_5_indention_options = _indent_not_parent_border.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentNotParentPattern(boolean paramBoolean) {
/*  571 */     this.field_5_indention_options = _indent_not_parent_pattern.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndentNotParentCellOptions(boolean paramBoolean) {
/*  587 */     this.field_5_indention_options = _indent_not_parent_cell_options.setShortBoolean(this.field_5_indention_options, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderOptions(short paramShort) {
/*  604 */     this.field_6_border_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderLeft(short paramShort) {
/*  633 */     this.field_6_border_options = _border_left.setShortValue(this.field_6_border_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderRight(short paramShort) {
/*  661 */     this.field_6_border_options = _border_right.setShortValue(this.field_6_border_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderTop(short paramShort) {
/*  689 */     this.field_6_border_options = _border_top.setShortValue(this.field_6_border_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderBottom(short paramShort) {
/*  717 */     this.field_6_border_options = _border_bottom.setShortValue(this.field_6_border_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPaletteOptions(short paramShort) {
/*  734 */     this.field_7_palette_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLeftBorderPaletteIdx(short paramShort) {
/*  749 */     this.field_7_palette_options = _left_border_palette_idx.setShortValue(this.field_7_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightBorderPaletteIdx(short paramShort) {
/*  764 */     this.field_7_palette_options = _right_border_palette_idx.setShortValue(this.field_7_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDiag(short paramShort) {
/*  782 */     this.field_7_palette_options = _diag.setShortValue(this.field_7_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdtlPaletteOptions(short paramShort) {
/*  799 */     this.field_8_adtl_palette_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTopBorderPaletteIdx(short paramShort) {
/*  814 */     this.field_8_adtl_palette_options = _top_border_palette_idx.setValue(this.field_8_adtl_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBottomBorderPaletteIdx(short paramShort) {
/*  829 */     this.field_8_adtl_palette_options = _bottom_border_palette_idx.setValue(this.field_8_adtl_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdtlDiag(short paramShort) {
/*  845 */     this.field_8_adtl_palette_options = _adtl_diag.setValue(this.field_8_adtl_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdtlDiagLineStyle(short paramShort) {
/*  873 */     this.field_8_adtl_palette_options = _adtl_diag_line_style.setValue(this.field_8_adtl_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdtlFillPattern(short paramShort) {
/*  905 */     this.field_8_adtl_palette_options = _adtl_fill_pattern.setValue(this.field_8_adtl_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillPaletteOptions(short paramShort) {
/*  917 */     this.field_9_fill_palette_options = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillForeground(short paramShort) {
/*  930 */     this.field_9_fill_palette_options = _fill_foreground.setShortValue(this.field_9_fill_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillBackground(short paramShort) {
/*  945 */     this.field_9_fill_palette_options = _fill_background.setShortValue(this.field_9_fill_palette_options, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFontIndex() {
/*  960 */     return this.field_1_font_index;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFormatIndex() {
/*  973 */     return this.field_2_format_index;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getCellOptions() {
/*  987 */     return this.field_3_cell_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLocked() {
/* 1002 */     return _locked.isSet(this.field_3_cell_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isHidden() {
/* 1015 */     return _hidden.isSet(this.field_3_cell_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getXFType() {
/* 1030 */     return _xf_type.getShortValue(this.field_3_cell_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean get123Prefix() {
/* 1043 */     return _123_prefix.isSet(this.field_3_cell_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getParentIndex() {
/* 1057 */     return _parent_index.getShortValue(this.field_3_cell_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAlignmentOptions() {
/* 1072 */     return this.field_4_alignment_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAlignment() {
/* 1094 */     return _alignment.getShortValue(this.field_4_alignment_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getWrapText() {
/* 1107 */     return _wrap_text.isSet(this.field_4_alignment_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getVerticalAlignment() {
/* 1125 */     return _vertical_alignment.getShortValue(this.field_4_alignment_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getJustifyLast() {
/* 1139 */     return _justify_last.getShortValue(this.field_4_alignment_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getRotation() {
/* 1152 */     return _rotation.getShortValue(this.field_4_alignment_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndentionOptions() {
/* 1168 */     return this.field_5_indention_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndent() {
/* 1182 */     return _indent.getShortValue(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getShrinkToFit() {
/* 1195 */     return _shrink_to_fit.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getMergeCells() {
/* 1208 */     return _merge_cells.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getReadingOrder() {
/* 1221 */     return _reading_order.getShortValue(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIndentNotParentFormat() {
/* 1235 */     return _indent_not_parent_format.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIndentNotParentFont() {
/* 1249 */     return _indent_not_parent_font.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIndentNotParentAlignment() {
/* 1263 */     return _indent_not_parent_alignment.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIndentNotParentBorder() {
/* 1277 */     return _indent_not_parent_border.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIndentNotParentPattern() {
/* 1291 */     return _indent_not_parent_pattern.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIndentNotParentCellOptions() {
/* 1305 */     return _indent_not_parent_cell_options.isSet(this.field_5_indention_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderOptions() {
/* 1322 */     return this.field_6_border_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderLeft() {
/* 1351 */     return _border_left.getShortValue(this.field_6_border_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderRight() {
/* 1378 */     return _border_right.getShortValue(this.field_6_border_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderTop() {
/* 1405 */     return _border_top.getShortValue(this.field_6_border_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderBottom() {
/* 1432 */     return _border_bottom.getShortValue(this.field_6_border_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getPaletteOptions() {
/* 1448 */     return this.field_7_palette_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getLeftBorderPaletteIdx() {
/* 1463 */     return _left_border_palette_idx.getShortValue(this.field_7_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getRightBorderPaletteIdx() {
/* 1477 */     return _right_border_palette_idx.getShortValue(this.field_7_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getDiag() {
/* 1494 */     return _diag.getShortValue(this.field_7_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAdtlPaletteOptions() {
/* 1511 */     return this.field_8_adtl_palette_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getTopBorderPaletteIdx() {
/* 1526 */     return (short)_top_border_palette_idx.getValue(this.field_8_adtl_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBottomBorderPaletteIdx() {
/* 1540 */     return (short)_bottom_border_palette_idx.getValue(this.field_8_adtl_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAdtlDiag() {
/* 1555 */     return (short)_adtl_diag.getValue(this.field_8_adtl_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAdtlDiagLineStyle() {
/* 1582 */     return (short)_adtl_diag_line_style.getValue(this.field_8_adtl_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getAdtlFillPattern() {
/* 1613 */     return (short)_adtl_fill_pattern.getValue(this.field_8_adtl_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFillPaletteOptions() {
/* 1630 */     return this.field_9_fill_palette_options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFillForeground() {
/* 1645 */     return _fill_foreground.getShortValue(this.field_9_fill_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFillBackground() {
/* 1657 */     return _fill_background.getShortValue(this.field_9_fill_palette_options);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1663 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     
/* 1665 */     stringBuffer.append("[EXTENDEDFORMAT]\n");
/* 1666 */     if (getXFType() == 1) {
/*      */       
/* 1668 */       stringBuffer.append(" STYLE_RECORD_TYPE\n");
/*      */     }
/* 1670 */     else if (getXFType() == 0) {
/*      */       
/* 1672 */       stringBuffer.append(" CELL_RECORD_TYPE\n");
/*      */     } 
/* 1674 */     stringBuffer.append("    .fontindex       = ").append(Integer.toHexString(getFontIndex())).append("\n");
/*      */     
/* 1676 */     stringBuffer.append("    .formatindex     = ").append(Integer.toHexString(getFormatIndex())).append("\n");
/*      */     
/* 1678 */     stringBuffer.append("    .celloptions     = ").append(Integer.toHexString(getCellOptions())).append("\n");
/*      */     
/* 1680 */     stringBuffer.append("          .islocked  = ").append(isLocked()).append("\n");
/*      */     
/* 1682 */     stringBuffer.append("          .ishidden  = ").append(isHidden()).append("\n");
/*      */     
/* 1684 */     stringBuffer.append("          .recordtype= ").append(Integer.toHexString(getXFType())).append("\n");
/*      */     
/* 1686 */     stringBuffer.append("          .parentidx = ").append(Integer.toHexString(getParentIndex())).append("\n");
/*      */     
/* 1688 */     stringBuffer.append("    .alignmentoptions= ").append(Integer.toHexString(getAlignmentOptions())).append("\n");
/*      */     
/* 1690 */     stringBuffer.append("          .alignment = ").append(getAlignment()).append("\n");
/*      */     
/* 1692 */     stringBuffer.append("          .wraptext  = ").append(getWrapText()).append("\n");
/*      */     
/* 1694 */     stringBuffer.append("          .valignment= ").append(Integer.toHexString(getVerticalAlignment())).append("\n");
/*      */     
/* 1696 */     stringBuffer.append("          .justlast  = ").append(Integer.toHexString(getJustifyLast())).append("\n");
/*      */     
/* 1698 */     stringBuffer.append("          .rotation  = ").append(Integer.toHexString(getRotation())).append("\n");
/*      */     
/* 1700 */     stringBuffer.append("    .indentionoptions= ").append(Integer.toHexString(getIndentionOptions())).append("\n");
/*      */     
/* 1702 */     stringBuffer.append("          .indent    = ").append(Integer.toHexString(getIndent())).append("\n");
/*      */     
/* 1704 */     stringBuffer.append("          .shrinktoft= ").append(getShrinkToFit()).append("\n");
/*      */     
/* 1706 */     stringBuffer.append("          .mergecells= ").append(getMergeCells()).append("\n");
/*      */     
/* 1708 */     stringBuffer.append("          .readngordr= ").append(Integer.toHexString(getReadingOrder())).append("\n");
/*      */     
/* 1710 */     stringBuffer.append("          .formatflag= ").append(isIndentNotParentFormat()).append("\n");
/*      */     
/* 1712 */     stringBuffer.append("          .fontflag  = ").append(isIndentNotParentFont()).append("\n");
/*      */     
/* 1714 */     stringBuffer.append("          .prntalgnmt= ").append(isIndentNotParentAlignment()).append("\n");
/*      */     
/* 1716 */     stringBuffer.append("          .borderflag= ").append(isIndentNotParentBorder()).append("\n");
/*      */     
/* 1718 */     stringBuffer.append("          .paternflag= ").append(isIndentNotParentPattern()).append("\n");
/*      */     
/* 1720 */     stringBuffer.append("          .celloption= ").append(isIndentNotParentCellOptions()).append("\n");
/*      */     
/* 1722 */     stringBuffer.append("    .borderoptns     = ").append(Integer.toHexString(getBorderOptions())).append("\n");
/*      */     
/* 1724 */     stringBuffer.append("          .lftln     = ").append(Integer.toHexString(getBorderLeft())).append("\n");
/*      */     
/* 1726 */     stringBuffer.append("          .rgtln     = ").append(Integer.toHexString(getBorderRight())).append("\n");
/*      */     
/* 1728 */     stringBuffer.append("          .topln     = ").append(Integer.toHexString(getBorderTop())).append("\n");
/*      */     
/* 1730 */     stringBuffer.append("          .btmln     = ").append(Integer.toHexString(getBorderBottom())).append("\n");
/*      */     
/* 1732 */     stringBuffer.append("    .paleteoptns     = ").append(Integer.toHexString(getPaletteOptions())).append("\n");
/*      */     
/* 1734 */     stringBuffer.append("          .leftborder= ").append(Integer.toHexString(getLeftBorderPaletteIdx())).append("\n");
/*      */ 
/*      */     
/* 1737 */     stringBuffer.append("          .rghtborder= ").append(Integer.toHexString(getRightBorderPaletteIdx())).append("\n");
/*      */ 
/*      */     
/* 1740 */     stringBuffer.append("          .diag      = ").append(Integer.toHexString(getDiag())).append("\n");
/*      */     
/* 1742 */     stringBuffer.append("    .paleteoptn2     = ").append(Integer.toHexString(getAdtlPaletteOptions())).append("\n");
/*      */ 
/*      */     
/* 1745 */     stringBuffer.append("          .topborder = ").append(Integer.toHexString(getTopBorderPaletteIdx())).append("\n");
/*      */ 
/*      */     
/* 1748 */     stringBuffer.append("          .botmborder= ").append(Integer.toHexString(getBottomBorderPaletteIdx())).append("\n");
/*      */ 
/*      */     
/* 1751 */     stringBuffer.append("          .adtldiag  = ").append(Integer.toHexString(getAdtlDiag())).append("\n");
/*      */     
/* 1753 */     stringBuffer.append("          .diaglnstyl= ").append(Integer.toHexString(getAdtlDiagLineStyle())).append("\n");
/*      */     
/* 1755 */     stringBuffer.append("          .fillpattrn= ").append(Integer.toHexString(getAdtlFillPattern())).append("\n");
/*      */     
/* 1757 */     stringBuffer.append("    .fillpaloptn     = ").append(Integer.toHexString(getFillPaletteOptions())).append("\n");
/*      */ 
/*      */     
/* 1760 */     stringBuffer.append("          .foreground= ").append(Integer.toHexString(getFillForeground())).append("\n");
/*      */     
/* 1762 */     stringBuffer.append("          .background= ").append(Integer.toHexString(getFillBackground())).append("\n");
/*      */     
/* 1764 */     stringBuffer.append("[/EXTENDEDFORMAT]\n");
/* 1765 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 1770 */     paramLittleEndianOutput.writeShort(getFontIndex());
/* 1771 */     paramLittleEndianOutput.writeShort(getFormatIndex());
/* 1772 */     paramLittleEndianOutput.writeShort(getCellOptions());
/* 1773 */     paramLittleEndianOutput.writeShort(getAlignmentOptions());
/* 1774 */     paramLittleEndianOutput.writeShort(getIndentionOptions());
/* 1775 */     paramLittleEndianOutput.writeShort(getBorderOptions());
/* 1776 */     paramLittleEndianOutput.writeShort(getPaletteOptions());
/* 1777 */     paramLittleEndianOutput.writeInt(getAdtlPaletteOptions());
/* 1778 */     paramLittleEndianOutput.writeShort(getFillPaletteOptions());
/*      */   }
/*      */ 
/*      */   
/*      */   protected int getDataSize() {
/* 1783 */     return 20;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short getSid() {
/* 1789 */     return 224;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cloneStyleFrom(ExtendedFormatRecord paramExtendedFormatRecord) {
/* 1804 */     this.field_1_font_index = paramExtendedFormatRecord.field_1_font_index;
/* 1805 */     this.field_2_format_index = paramExtendedFormatRecord.field_2_format_index;
/* 1806 */     this.field_3_cell_options = paramExtendedFormatRecord.field_3_cell_options;
/* 1807 */     this.field_4_alignment_options = paramExtendedFormatRecord.field_4_alignment_options;
/* 1808 */     this.field_5_indention_options = paramExtendedFormatRecord.field_5_indention_options;
/* 1809 */     this.field_6_border_options = paramExtendedFormatRecord.field_6_border_options;
/* 1810 */     this.field_7_palette_options = paramExtendedFormatRecord.field_7_palette_options;
/* 1811 */     this.field_8_adtl_palette_options = paramExtendedFormatRecord.field_8_adtl_palette_options;
/* 1812 */     this.field_9_fill_palette_options = paramExtendedFormatRecord.field_9_fill_palette_options;
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1817 */     byte b = 31;
/* 1818 */     int i = 1;
/* 1819 */     i = 31 * i + this.field_1_font_index;
/* 1820 */     i = 31 * i + this.field_2_format_index;
/* 1821 */     i = 31 * i + this.field_3_cell_options;
/* 1822 */     i = 31 * i + this.field_4_alignment_options;
/* 1823 */     i = 31 * i + this.field_5_indention_options;
/* 1824 */     i = 31 * i + this.field_6_border_options;
/* 1825 */     i = 31 * i + this.field_7_palette_options;
/* 1826 */     i = 31 * i + this.field_8_adtl_palette_options;
/* 1827 */     i = 31 * i + this.field_9_fill_palette_options;
/* 1828 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1838 */     if (this == paramObject)
/* 1839 */       return true; 
/* 1840 */     if (paramObject == null)
/* 1841 */       return false; 
/* 1842 */     if (paramObject instanceof ExtendedFormatRecord) {
/* 1843 */       ExtendedFormatRecord extendedFormatRecord = (ExtendedFormatRecord)paramObject;
/* 1844 */       if (this.field_1_font_index != extendedFormatRecord.field_1_font_index)
/* 1845 */         return false; 
/* 1846 */       if (this.field_2_format_index != extendedFormatRecord.field_2_format_index)
/* 1847 */         return false; 
/* 1848 */       if (this.field_3_cell_options != extendedFormatRecord.field_3_cell_options)
/* 1849 */         return false; 
/* 1850 */       if (this.field_4_alignment_options != extendedFormatRecord.field_4_alignment_options)
/* 1851 */         return false; 
/* 1852 */       if (this.field_5_indention_options != extendedFormatRecord.field_5_indention_options)
/* 1853 */         return false; 
/* 1854 */       if (this.field_6_border_options != extendedFormatRecord.field_6_border_options)
/* 1855 */         return false; 
/* 1856 */       if (this.field_7_palette_options != extendedFormatRecord.field_7_palette_options)
/* 1857 */         return false; 
/* 1858 */       if (this.field_8_adtl_palette_options != extendedFormatRecord.field_8_adtl_palette_options)
/* 1859 */         return false; 
/* 1860 */       if (this.field_9_fill_palette_options != extendedFormatRecord.field_9_fill_palette_options)
/* 1861 */         return false; 
/* 1862 */       return true;
/*      */     } 
/* 1864 */     return false;
/*      */   }
/*      */   
/*      */   public int[] stateSummary() {
/* 1868 */     return new int[] { this.field_1_font_index, this.field_2_format_index, this.field_3_cell_options, this.field_4_alignment_options, this.field_5_indention_options, this.field_6_border_options, this.field_7_palette_options, this.field_8_adtl_palette_options, this.field_9_fill_palette_options };
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ExtendedFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */