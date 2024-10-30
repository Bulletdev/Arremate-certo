/*    */ package org.apache.poi.sl.usermodel;public interface TextRun { String getRawText();
/*    */   void setText(String paramString);
/*    */   TextCap getTextCap();
/*    */   PaintStyle getFontColor();
/*    */   void setFontColor(Color paramColor);
/*    */   void setFontColor(PaintStyle paramPaintStyle);
/*    */   Double getFontSize();
/*    */   void setFontSize(Double paramDouble);
/*    */   String getFontFamily();
/*    */   void setFontFamily(String paramString);
/*    */   boolean isBold();
/*    */   void setBold(boolean paramBoolean);
/*    */   boolean isItalic();
/*    */   void setItalic(boolean paramBoolean);
/*    */   boolean isUnderlined();
/*    */   void setUnderlined(boolean paramBoolean);
/*    */   boolean isStrikethrough();
/*    */   void setStrikethrough(boolean paramBoolean);
/*    */   boolean isSubscript();
/*    */   
/*    */   boolean isSuperscript();
/*    */   
/*    */   byte getPitchAndFamily();
/*    */   
/*    */   Hyperlink<?, ?> getHyperlink();
/*    */   
/*    */   Hyperlink<?, ?> createHyperlink();
/*    */   
/* 29 */   public enum TextCap { NONE,
/* 30 */     SMALL,
/* 31 */     ALL; }
/*    */    }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\TextRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */