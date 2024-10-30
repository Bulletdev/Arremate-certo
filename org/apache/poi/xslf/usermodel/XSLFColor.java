/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import org.apache.poi.sl.draw.DrawPaint;
/*     */ import org.apache.poi.sl.usermodel.ColorStyle;
/*     */ import org.apache.poi.sl.usermodel.PresetColor;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
/*     */ import org.w3c.dom.Node;
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
/*     */ @Internal
/*     */ public class XSLFColor
/*     */ {
/*  49 */   private static POILogger LOGGER = POILogFactory.getLogger(XSLFColor.class);
/*     */   
/*     */   private XmlObject _xmlObject;
/*     */   private Color _color;
/*     */   private CTSchemeColor _phClr;
/*     */   
/*     */   public XSLFColor(XmlObject paramXmlObject, XSLFTheme paramXSLFTheme, CTSchemeColor paramCTSchemeColor) {
/*  56 */     this._xmlObject = paramXmlObject;
/*  57 */     this._phClr = paramCTSchemeColor;
/*  58 */     this._color = toColor(paramXmlObject, paramXSLFTheme);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public XmlObject getXmlObject() {
/*  63 */     return this._xmlObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/*  72 */     return DrawPaint.applyColorTransform(getColorStyle());
/*     */   }
/*     */   
/*     */   public ColorStyle getColorStyle() {
/*  76 */     return new ColorStyle() {
/*     */         public Color getColor() {
/*  78 */           return XSLFColor.this._color;
/*     */         }
/*     */         
/*     */         public int getAlpha() {
/*  82 */           return XSLFColor.this.getRawValue("alpha");
/*     */         }
/*     */         
/*     */         public int getHueOff() {
/*  86 */           return XSLFColor.this.getRawValue("hueOff");
/*     */         }
/*     */         
/*     */         public int getHueMod() {
/*  90 */           return XSLFColor.this.getRawValue("hueMod");
/*     */         }
/*     */         
/*     */         public int getSatOff() {
/*  94 */           return XSLFColor.this.getRawValue("satOff");
/*     */         }
/*     */         
/*     */         public int getSatMod() {
/*  98 */           return XSLFColor.this.getRawValue("satMod");
/*     */         }
/*     */         
/*     */         public int getLumOff() {
/* 102 */           return XSLFColor.this.getRawValue("lumOff");
/*     */         }
/*     */         
/*     */         public int getLumMod() {
/* 106 */           return XSLFColor.this.getRawValue("lumMod");
/*     */         }
/*     */         
/*     */         public int getShade() {
/* 110 */           return XSLFColor.this.getRawValue("shade");
/*     */         }
/*     */         
/*     */         public int getTint() {
/* 114 */           return XSLFColor.this.getRawValue("tint");
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   Color toColor(XmlObject paramXmlObject, XSLFTheme paramXSLFTheme) {
/* 120 */     Color color = null;
/* 121 */     for (XmlObject xmlObject : paramXmlObject.selectPath("*")) {
/* 122 */       if (xmlObject instanceof CTHslColor) {
/* 123 */         CTHslColor cTHslColor = (CTHslColor)xmlObject;
/* 124 */         int i = cTHslColor.getHue2();
/* 125 */         int j = cTHslColor.getSat2();
/* 126 */         int k = cTHslColor.getLum2();
/* 127 */         color = DrawPaint.HSL2RGB(i / 60000.0D, j / 1000.0D, k / 1000.0D, 1.0D);
/* 128 */       } else if (xmlObject instanceof CTPresetColor) {
/* 129 */         CTPresetColor cTPresetColor = (CTPresetColor)xmlObject;
/* 130 */         String str = cTPresetColor.getVal().toString();
/* 131 */         PresetColor presetColor = PresetColor.valueOfOoxmlId(str);
/* 132 */         if (presetColor != null) {
/* 133 */           color = presetColor.color;
/*     */         }
/* 135 */       } else if (xmlObject instanceof CTSchemeColor) {
/* 136 */         CTSchemeColor cTSchemeColor = (CTSchemeColor)xmlObject;
/* 137 */         String str = cTSchemeColor.getVal().toString();
/* 138 */         if (this._phClr != null)
/*     */         {
/* 140 */           str = this._phClr.getVal().toString();
/*     */         }
/*     */         
/* 143 */         CTColor cTColor = paramXSLFTheme.getCTColor(str);
/* 144 */         if (cTColor != null) color = toColor((XmlObject)cTColor, null); 
/* 145 */       } else if (xmlObject instanceof CTScRgbColor) {
/*     */         
/* 147 */         CTScRgbColor cTScRgbColor = (CTScRgbColor)xmlObject;
/* 148 */         color = new Color(DrawPaint.lin2srgb(cTScRgbColor.getR()), DrawPaint.lin2srgb(cTScRgbColor.getG()), DrawPaint.lin2srgb(cTScRgbColor.getB()));
/* 149 */       } else if (xmlObject instanceof CTSRgbColor) {
/*     */         
/* 151 */         CTSRgbColor cTSRgbColor = (CTSRgbColor)xmlObject;
/* 152 */         byte[] arrayOfByte = cTSRgbColor.getVal();
/* 153 */         color = new Color(0xFF & arrayOfByte[0], 0xFF & arrayOfByte[1], 0xFF & arrayOfByte[2]);
/* 154 */       } else if (xmlObject instanceof CTSystemColor) {
/* 155 */         CTSystemColor cTSystemColor = (CTSystemColor)xmlObject;
/* 156 */         if (cTSystemColor.isSetLastClr()) {
/* 157 */           byte[] arrayOfByte = cTSystemColor.getLastClr();
/* 158 */           color = new Color(0xFF & arrayOfByte[0], 0xFF & arrayOfByte[1], 0xFF & arrayOfByte[2]);
/*     */         } else {
/* 160 */           String str = cTSystemColor.getVal().toString();
/* 161 */           PresetColor presetColor = PresetColor.valueOfOoxmlId(str);
/* 162 */           if (presetColor != null) {
/* 163 */             color = presetColor.color;
/*     */           }
/* 165 */           if (color == null) {
/* 166 */             color = Color.black;
/*     */           }
/*     */         } 
/* 169 */       } else if (!(xmlObject instanceof org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference)) {
/*     */ 
/*     */ 
/*     */         
/* 173 */         throw new IllegalArgumentException("Unexpected color choice: " + xmlObject.getClass());
/*     */       } 
/*     */     } 
/* 176 */     return color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   protected void setColor(Color paramColor) {
/*     */     CTPositiveFixedPercentage cTPositiveFixedPercentage;
/* 186 */     if (!(this._xmlObject instanceof CTSolidColorFillProperties)) {
/* 187 */       LOGGER.log(7, new Object[] { "XSLFColor.setColor currently only supports CTSolidColorFillProperties" });
/*     */       return;
/*     */     } 
/* 190 */     CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties)this._xmlObject;
/* 191 */     if (cTSolidColorFillProperties.isSetSrgbClr()) {
/* 192 */       cTSolidColorFillProperties.unsetSrgbClr();
/*     */     }
/*     */     
/* 195 */     if (cTSolidColorFillProperties.isSetScrgbClr()) {
/* 196 */       cTSolidColorFillProperties.unsetScrgbClr();
/*     */     }
/*     */     
/* 199 */     if (cTSolidColorFillProperties.isSetHslClr()) {
/* 200 */       cTSolidColorFillProperties.unsetHslClr();
/*     */     }
/*     */     
/* 203 */     if (cTSolidColorFillProperties.isSetPrstClr()) {
/* 204 */       cTSolidColorFillProperties.unsetPrstClr();
/*     */     }
/*     */     
/* 207 */     if (cTSolidColorFillProperties.isSetSchemeClr()) {
/* 208 */       cTSolidColorFillProperties.unsetSchemeClr();
/*     */     }
/*     */     
/* 211 */     if (cTSolidColorFillProperties.isSetSysClr()) {
/* 212 */       cTSolidColorFillProperties.unsetSysClr();
/*     */     }
/*     */     
/* 215 */     float[] arrayOfFloat = paramColor.getRGBComponents(null);
/* 216 */     boolean bool = (arrayOfFloat.length == 4 && arrayOfFloat[3] < 1.0F) ? true : false;
/*     */ 
/*     */ 
/*     */     
/* 220 */     if (isInt(arrayOfFloat[0]) && isInt(arrayOfFloat[1]) && isInt(arrayOfFloat[2])) {
/*     */       
/* 222 */       CTSRgbColor cTSRgbColor = cTSolidColorFillProperties.addNewSrgbClr();
/*     */       
/* 224 */       byte[] arrayOfByte = { (byte)paramColor.getRed(), (byte)paramColor.getGreen(), (byte)paramColor.getBlue() };
/* 225 */       cTSRgbColor.setVal(arrayOfByte);
/* 226 */       cTPositiveFixedPercentage = bool ? cTSRgbColor.addNewAlpha() : null;
/*     */     } else {
/* 228 */       CTScRgbColor cTScRgbColor = cTSolidColorFillProperties.addNewScrgbClr();
/* 229 */       cTScRgbColor.setR(DrawPaint.srgb2lin(arrayOfFloat[0]));
/* 230 */       cTScRgbColor.setG(DrawPaint.srgb2lin(arrayOfFloat[1]));
/* 231 */       cTScRgbColor.setB(DrawPaint.srgb2lin(arrayOfFloat[2]));
/* 232 */       cTPositiveFixedPercentage = bool ? cTScRgbColor.addNewAlpha() : null;
/*     */     } 
/*     */ 
/*     */     
/* 236 */     if (cTPositiveFixedPercentage != null) {
/* 237 */       cTPositiveFixedPercentage.setVal((int)(100000.0F * arrayOfFloat[3]));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isInt(float paramFloat) {
/* 245 */     return (Math.abs((paramFloat * 255.0F) - Math.rint((paramFloat * 255.0F))) < 9.999999747378752E-6D);
/*     */   }
/*     */   
/*     */   private int getRawValue(String paramString) {
/* 249 */     String str = "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' $this//a:" + paramString;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     if (this._phClr != null) {
/* 255 */       XmlObject[] arrayOfXmlObject1 = this._phClr.selectPath(str);
/* 256 */       if (arrayOfXmlObject1.length == 1) {
/* 257 */         Node node = arrayOfXmlObject1[0].getDomNode().getAttributes().getNamedItem("val");
/* 258 */         if (node != null) {
/* 259 */           return Integer.parseInt(node.getNodeValue());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 264 */     XmlObject[] arrayOfXmlObject = this._xmlObject.selectPath(str);
/* 265 */     if (arrayOfXmlObject.length == 1) {
/* 266 */       Node node = arrayOfXmlObject[0].getDomNode().getAttributes().getNamedItem("val");
/* 267 */       if (node != null) {
/* 268 */         return Integer.parseInt(node.getNodeValue());
/*     */       }
/*     */     } 
/*     */     
/* 272 */     return -1;
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
/*     */   
/*     */   private int getPercentageValue(String paramString) {
/* 285 */     int i = getRawValue(paramString);
/* 286 */     return (i == -1) ? i : (i / 1000);
/*     */   }
/*     */   
/*     */   private int getAngleValue(String paramString) {
/* 290 */     int i = getRawValue(paramString);
/* 291 */     return (i == -1) ? i : (i / 60000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getAlpha() {
/* 301 */     return getPercentageValue("alpha");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getAlphaMod() {
/* 311 */     return getPercentageValue("alphaMod");
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
/*     */   int getAlphaOff() {
/* 323 */     return getPercentageValue("alphaOff");
/*     */   }
/*     */ 
/*     */   
/*     */   int getHue() {
/* 328 */     return getAngleValue("hue");
/*     */   }
/*     */   
/*     */   int getHueMod() {
/* 332 */     return getPercentageValue("hueMod");
/*     */   }
/*     */   
/*     */   int getHueOff() {
/* 336 */     return getPercentageValue("hueOff");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getLum() {
/* 347 */     return getPercentageValue("lum");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getLumMod() {
/* 357 */     return getPercentageValue("lumMod");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getLumOff() {
/* 367 */     return getPercentageValue("lumOff");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getSat() {
/* 378 */     return getPercentageValue("sat");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getSatMod() {
/* 388 */     return getPercentageValue("satMod");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getSatOff() {
/* 398 */     return getPercentageValue("satOff");
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
/*     */   int getRed() {
/* 410 */     return getPercentageValue("red");
/*     */   }
/*     */   
/*     */   int getRedMod() {
/* 414 */     return getPercentageValue("redMod");
/*     */   }
/*     */   
/*     */   int getRedOff() {
/* 418 */     return getPercentageValue("redOff");
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
/*     */   int getGreen() {
/* 430 */     return getPercentageValue("green");
/*     */   }
/*     */   
/*     */   int getGreenMod() {
/* 434 */     return getPercentageValue("greenMod");
/*     */   }
/*     */   
/*     */   int getGreenOff() {
/* 438 */     return getPercentageValue("greenOff");
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
/*     */   int getBlue() {
/* 450 */     return getPercentageValue("blue");
/*     */   }
/*     */   
/*     */   int getBlueMod() {
/* 454 */     return getPercentageValue("blueMod");
/*     */   }
/*     */   
/*     */   int getBlueOff() {
/* 458 */     return getPercentageValue("blueOff");
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
/*     */   public int getShade() {
/* 470 */     return getPercentageValue("shade");
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
/*     */   public int getTint() {
/* 482 */     return getPercentageValue("tint");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */