/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import java.awt.RenderingHints;
/*    */ import org.apache.poi.util.Internal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSLFRenderingHint
/*    */   extends RenderingHints.Key
/*    */ {
/*    */   public XSLFRenderingHint(int paramInt) {
/* 33 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCompatibleValue(Object paramObject) {
/* 38 */     return true;
/*    */   }
/*    */   
/* 41 */   public static final XSLFRenderingHint GSAVE = new XSLFRenderingHint(1);
/* 42 */   public static final XSLFRenderingHint GRESTORE = new XSLFRenderingHint(2);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   public static final XSLFRenderingHint IMAGE_RENDERER = new XSLFRenderingHint(3);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 65 */   public static final XSLFRenderingHint TEXT_RENDERING_MODE = new XSLFRenderingHint(4);
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int TEXT_AS_CHARACTERS = 1;
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int TEXT_AS_SHAPES = 2;
/*    */ 
/*    */ 
/*    */   
/*    */   @Internal
/* 78 */   static final XSLFRenderingHint GROUP_TRANSFORM = new XSLFRenderingHint(5);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 83 */   public static final XSLFRenderingHint FONT_HANDLER = new XSLFRenderingHint(6);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFRenderingHint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */