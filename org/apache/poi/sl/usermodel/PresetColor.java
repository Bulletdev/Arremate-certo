/*     */ package org.apache.poi.sl.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum PresetColor
/*     */ {
/*  42 */   ActiveBorder(Integer.valueOf(-4934476), 1, "activeBorder"),
/*     */   
/*  44 */   ActiveCaption(Integer.valueOf(-6703919), 2, "activeCaption"),
/*     */   
/*  46 */   ActiveCaptionText(Integer.valueOf(-16777216), 3, "captionText"),
/*     */   
/*  48 */   AppWorkspace(Integer.valueOf(-5526613), 4, "appWorkspace"),
/*     */   
/*  50 */   Control(Integer.valueOf(-986896), 5, "btnFace"),
/*     */   
/*  52 */   ControlDark(Integer.valueOf(-9868951), 6, "btnShadow"),
/*     */   
/*  54 */   ControlDarkDark(Integer.valueOf(-16777216), 7, "3dDkShadow"),
/*     */   
/*  56 */   ControlLight(Integer.valueOf(-1842205), 8, "btnHighlight"),
/*     */   
/*  58 */   ControlLightLight(Integer.valueOf(-1842205), 9, "3dLight"),
/*     */   
/*  60 */   ControlText(Integer.valueOf(-16777216), 10, "btnText"),
/*     */   
/*  62 */   Desktop(Integer.valueOf(-16777216), 11, "background"),
/*     */   
/*  64 */   GrayText(Integer.valueOf(-9605779), 12, "grayText"),
/*     */   
/*  66 */   Highlight(Integer.valueOf(-13395457), 13, "highlight"),
/*     */   
/*  68 */   HighlightText(Integer.valueOf(-1), 14, "highlightText"),
/*     */   
/*  70 */   HotTrack(Integer.valueOf(-16750900), 15, "hotLight"),
/*     */   
/*  72 */   InactiveBorder(Integer.valueOf(-722948), 16, "inactiveBorder"),
/*     */   
/*  74 */   InactiveCaption(Integer.valueOf(-4207141), 17, "inactiveCaption"),
/*     */   
/*  76 */   InactiveCaptionText(Integer.valueOf(-16777216), 18, "inactiveCaptionText"),
/*     */   
/*  78 */   Info(Integer.valueOf(-31), 19, "infoBk"),
/*     */   
/*  80 */   InfoText(Integer.valueOf(-16777216), 20, "infoText"),
/*     */   
/*  82 */   Menu(Integer.valueOf(-986896), 21, "menu"),
/*     */   
/*  84 */   MenuText(Integer.valueOf(-16777216), 22, "menuText"),
/*     */   
/*  86 */   ScrollBar(Integer.valueOf(-3618616), 23, "scrollBar"),
/*     */   
/*  88 */   Window(Integer.valueOf(-1), 24, "window"),
/*     */   
/*  90 */   WindowFrame(Integer.valueOf(-10197916), 25, "windowFrame"),
/*     */   
/*  92 */   WindowText(Integer.valueOf(-16777216), 26, "windowText"),
/*  93 */   Transparent(Integer.valueOf(16777215), 27, null),
/*  94 */   AliceBlue(Integer.valueOf(-984833), 28, "aliceBlue"),
/*  95 */   AntiqueWhite(Integer.valueOf(-332841), 29, "antiqueWhite"),
/*  96 */   Aqua(Integer.valueOf(-16711681), 30, "aqua"),
/*  97 */   Aquamarine(Integer.valueOf(-8388652), 31, "aquamarine"),
/*  98 */   Azure(Integer.valueOf(-983041), 32, "azure"),
/*  99 */   Beige(Integer.valueOf(-657956), 33, "beige"),
/* 100 */   Bisque(Integer.valueOf(-6972), 34, "bisque"),
/* 101 */   Black(Integer.valueOf(-16777216), 35, "black"),
/* 102 */   BlanchedAlmond(Integer.valueOf(-5171), 36, "blanchedAlmond"),
/* 103 */   Blue(Integer.valueOf(-16776961), 37, "blue"),
/* 104 */   BlueViolet(Integer.valueOf(-7722014), 38, "blueViolet"),
/* 105 */   Brown(Integer.valueOf(-5952982), 39, "brown"),
/* 106 */   BurlyWood(Integer.valueOf(-2180985), 40, "burlyWood"),
/* 107 */   CadetBlue(Integer.valueOf(-10510688), 41, "cadetBlue"),
/* 108 */   Chartreuse(Integer.valueOf(-8388864), 42, "chartreuse"),
/* 109 */   Chocolate(Integer.valueOf(-2987746), 43, "chocolate"),
/* 110 */   Coral(Integer.valueOf(-32944), 44, "coral"),
/* 111 */   CornflowerBlue(Integer.valueOf(-10185235), 45, "cornflowerBlue"),
/* 112 */   Cornsilk(Integer.valueOf(-1828), 46, "cornsilk"),
/* 113 */   Crimson(Integer.valueOf(-2354116), 47, "crimson"),
/* 114 */   Cyan(Integer.valueOf(-16711681), 48, "cyan"),
/* 115 */   DarkBlue(Integer.valueOf(-16777077), 49, "dkBlue"),
/* 116 */   DarkCyan(Integer.valueOf(-16741493), 50, "dkCyan"),
/* 117 */   DarkGoldenrod(Integer.valueOf(-4684277), 51, "dkGoldenrod"),
/* 118 */   DarkGray(Integer.valueOf(-5658199), 52, "dkGray"),
/* 119 */   DarkGreen(Integer.valueOf(-16751616), 53, "dkGreen"),
/* 120 */   DarkKhaki(Integer.valueOf(-4343957), 54, "dkKhaki"),
/* 121 */   DarkMagenta(Integer.valueOf(-7667573), 55, "dkMagenta"),
/* 122 */   DarkOliveGreen(Integer.valueOf(-11179217), 56, "dkOliveGreen"),
/* 123 */   DarkOrange(Integer.valueOf(-29696), 57, "dkOrange"),
/* 124 */   DarkOrchid(Integer.valueOf(-6737204), 58, "dkOrchid"),
/* 125 */   DarkRed(Integer.valueOf(-7667712), 59, "dkRed"),
/* 126 */   DarkSalmon(Integer.valueOf(-1468806), 60, "dkSalmon"),
/* 127 */   DarkSeaGreen(Integer.valueOf(-7357301), 61, "dkSeaGreen"),
/* 128 */   DarkSlateBlue(Integer.valueOf(-12042869), 62, "dkSlateBlue"),
/* 129 */   DarkSlateGray(Integer.valueOf(-13676721), 63, "dkSlateGray"),
/* 130 */   DarkTurquoise(Integer.valueOf(-16724271), 64, "dkTurquoise"),
/* 131 */   DarkViolet(Integer.valueOf(-7077677), 65, "dkViolet"),
/* 132 */   DeepPink(Integer.valueOf(-60269), 66, "deepPink"),
/* 133 */   DeepSkyBlue(Integer.valueOf(-16728065), 67, "deepSkyBlue"),
/* 134 */   DimGray(Integer.valueOf(-9868951), 68, "dimGray"),
/* 135 */   DodgerBlue(Integer.valueOf(-14774017), 69, "dodgerBlue"),
/* 136 */   Firebrick(Integer.valueOf(-5103070), 70, "firebrick"),
/* 137 */   FloralWhite(Integer.valueOf(-1296), 71, "floralWhite"),
/* 138 */   ForestGreen(Integer.valueOf(-14513374), 72, "forestGreen"),
/* 139 */   Fuchsia(Integer.valueOf(-65281), 73, "fuchsia"),
/* 140 */   Gainsboro(Integer.valueOf(-2302756), 74, "gainsboro"),
/* 141 */   GhostWhite(Integer.valueOf(-460545), 75, "ghostWhite"),
/* 142 */   Gold(Integer.valueOf(-10496), 76, "gold"),
/* 143 */   Goldenrod(Integer.valueOf(-2448096), 77, "goldenrod"),
/* 144 */   Gray(Integer.valueOf(-8355712), 78, "gray"),
/* 145 */   Green(Integer.valueOf(-16744448), 79, "green"),
/* 146 */   GreenYellow(Integer.valueOf(-5374161), 80, "greenYellow"),
/* 147 */   Honeydew(Integer.valueOf(-983056), 81, "honeydew"),
/* 148 */   HotPink(Integer.valueOf(-38476), 82, "hotPink"),
/* 149 */   IndianRed(Integer.valueOf(-3318692), 83, "indianRed"),
/* 150 */   Indigo(Integer.valueOf(-11861886), 84, "indigo"),
/* 151 */   Ivory(Integer.valueOf(-16), 85, "ivory"),
/* 152 */   Khaki(Integer.valueOf(-989556), 86, "khaki"),
/* 153 */   Lavender(Integer.valueOf(-1644806), 87, "lavender"),
/* 154 */   LavenderBlush(Integer.valueOf(-3851), 88, "lavenderBlush"),
/* 155 */   LawnGreen(Integer.valueOf(-8586240), 89, "lawnGreen"),
/* 156 */   LemonChiffon(Integer.valueOf(-1331), 90, "lemonChiffon"),
/* 157 */   LightBlue(Integer.valueOf(-5383962), 91, "ltBlue"),
/* 158 */   LightCoral(Integer.valueOf(-1015680), 92, "ltCoral"),
/* 159 */   LightCyan(Integer.valueOf(-2031617), 93, "ltCyan"),
/* 160 */   LightGoldenrodYellow(Integer.valueOf(-329096), 94, "ltGoldenrodYellow"),
/* 161 */   LightGray(Integer.valueOf(-2894893), 95, "ltGray"),
/* 162 */   LightGreen(Integer.valueOf(-7278960), 96, "ltGreen"),
/* 163 */   LightPink(Integer.valueOf(-18751), 97, "ltPink"),
/* 164 */   LightSalmon(Integer.valueOf(-24454), 98, "ltSalmon"),
/* 165 */   LightSeaGreen(Integer.valueOf(-14634326), 99, "ltSeaGreen"),
/* 166 */   LightSkyBlue(Integer.valueOf(-7876870), 100, "ltSkyBlue"),
/* 167 */   LightSlateGray(Integer.valueOf(-8943463), 101, "ltSlateGray"),
/* 168 */   LightSteelBlue(Integer.valueOf(-5192482), 102, "ltSteelBlue"),
/* 169 */   LightYellow(Integer.valueOf(-32), 103, "ltYellow"),
/* 170 */   Lime(Integer.valueOf(-16711936), 104, "lime"),
/* 171 */   LimeGreen(Integer.valueOf(-13447886), 105, "limeGreen"),
/* 172 */   Linen(Integer.valueOf(-331546), 106, "linen"),
/* 173 */   Magenta(Integer.valueOf(-65281), 107, "magenta"),
/* 174 */   Maroon(Integer.valueOf(-8388608), 108, "maroon"),
/* 175 */   MediumAquamarine(Integer.valueOf(-10039894), 109, "medAquamarine"),
/* 176 */   MediumBlue(Integer.valueOf(-16777011), 110, "medBlue"),
/* 177 */   MediumOrchid(Integer.valueOf(-4565549), 111, "medOrchid"),
/* 178 */   MediumPurple(Integer.valueOf(-7114533), 112, "medPurple"),
/* 179 */   MediumSeaGreen(Integer.valueOf(-12799119), 113, "medSeaGreen"),
/* 180 */   MediumSlateBlue(Integer.valueOf(-8689426), 114, "medSlateBlue"),
/* 181 */   MediumSpringGreen(Integer.valueOf(-16713062), 115, "medSpringGreen"),
/* 182 */   MediumTurquoise(Integer.valueOf(-12004916), 116, "medTurquoise"),
/* 183 */   MediumVioletRed(Integer.valueOf(-3730043), 117, "medVioletRed"),
/* 184 */   MidnightBlue(Integer.valueOf(-15132304), 118, "midnightBlue"),
/* 185 */   MintCream(Integer.valueOf(-655366), 119, "mintCream"),
/* 186 */   MistyRose(Integer.valueOf(-6943), 120, "mistyRose"),
/* 187 */   Moccasin(Integer.valueOf(-6987), 121, "moccasin"),
/* 188 */   NavajoWhite(Integer.valueOf(-8531), 122, "navajoWhite"),
/* 189 */   Navy(Integer.valueOf(-16777088), 123, "navy"),
/* 190 */   OldLace(Integer.valueOf(-133658), 124, "oldLace"),
/* 191 */   Olive(Integer.valueOf(-8355840), 125, "olive"),
/* 192 */   OliveDrab(Integer.valueOf(-9728477), 126, "oliveDrab"),
/* 193 */   Orange(Integer.valueOf(-23296), 127, "orange"),
/* 194 */   OrangeRed(Integer.valueOf(-47872), 128, "orangeRed"),
/* 195 */   Orchid(Integer.valueOf(-2461482), 129, "orchid"),
/* 196 */   PaleGoldenrod(Integer.valueOf(-1120086), 130, "paleGoldenrod"),
/* 197 */   PaleGreen(Integer.valueOf(-6751336), 131, "paleGreen"),
/* 198 */   PaleTurquoise(Integer.valueOf(-5247250), 132, "paleTurquoise"),
/* 199 */   PaleVioletRed(Integer.valueOf(-2396013), 133, "paleVioletRed"),
/* 200 */   PapayaWhip(Integer.valueOf(-4139), 134, "papayaWhip"),
/* 201 */   PeachPuff(Integer.valueOf(-9543), 135, "peachPuff"),
/* 202 */   Peru(Integer.valueOf(-3308225), 136, "peru"),
/* 203 */   Pink(Integer.valueOf(-16181), 137, "pink"),
/* 204 */   Plum(Integer.valueOf(-2252579), 138, "plum"),
/* 205 */   PowderBlue(Integer.valueOf(-5185306), 139, "powderBlue"),
/* 206 */   Purple(Integer.valueOf(-8388480), 140, "purple"),
/* 207 */   Red(Integer.valueOf(-65536), 141, "red"),
/* 208 */   RosyBrown(Integer.valueOf(-4419697), 142, "rosyBrown"),
/* 209 */   RoyalBlue(Integer.valueOf(-12490271), 143, "royalBlue"),
/* 210 */   SaddleBrown(Integer.valueOf(-7650029), 144, "saddleBrown"),
/* 211 */   Salmon(Integer.valueOf(-360334), 145, "salmon"),
/* 212 */   SandyBrown(Integer.valueOf(-744352), 146, "sandyBrown"),
/* 213 */   SeaGreen(Integer.valueOf(-13726889), 147, "seaGreen"),
/* 214 */   SeaShell(Integer.valueOf(-2578), 148, "seaShell"),
/* 215 */   Sienna(Integer.valueOf(-6270419), 149, "sienna"),
/* 216 */   Silver(Integer.valueOf(-4144960), 150, "silver"),
/* 217 */   SkyBlue(Integer.valueOf(-7876885), 151, "skyBlue"),
/* 218 */   SlateBlue(Integer.valueOf(-9807155), 152, "slateBlue"),
/* 219 */   SlateGray(Integer.valueOf(-9404272), 153, "slateGray"),
/* 220 */   Snow(Integer.valueOf(-1286), 154, "snow"),
/* 221 */   SpringGreen(Integer.valueOf(-16711809), 155, "springGreen"),
/* 222 */   SteelBlue(Integer.valueOf(-12156236), 156, "steelBlue"),
/* 223 */   Tan(Integer.valueOf(-2968436), 157, "tan"),
/* 224 */   Teal(Integer.valueOf(-16744320), 158, "teal"),
/* 225 */   Thistle(Integer.valueOf(-2572328), 159, "thistle"),
/* 226 */   Tomato(Integer.valueOf(-40121), 160, "tomato"),
/* 227 */   Turquoise(Integer.valueOf(-12525360), 161, "turquoise"),
/* 228 */   Violet(Integer.valueOf(-1146130), 162, "violet"),
/* 229 */   Wheat(Integer.valueOf(-663885), 163, "wheat"),
/* 230 */   White(Integer.valueOf(-1), 164, "white"),
/* 231 */   WhiteSmoke(Integer.valueOf(-657931), 165, "whiteSmoke"),
/* 232 */   Yellow(Integer.valueOf(-256), 166, "yellow"),
/* 233 */   YellowGreen(Integer.valueOf(-6632142), 167, "yellowGreen"),
/*     */   
/* 235 */   ButtonFace(Integer.valueOf(-986896), 168, null),
/*     */   
/* 237 */   ButtonHighlight(Integer.valueOf(-1), 169, null),
/*     */   
/* 239 */   ButtonShadow(Integer.valueOf(-6250336), 170, null),
/*     */   
/* 241 */   GradientActiveCaption(Integer.valueOf(-4599318), 171, "gradientActiveCaption"),
/*     */   
/* 243 */   GradientInactiveCaption(Integer.valueOf(-2628366), 172, "gradientInactiveCaption"),
/*     */   
/* 245 */   MenuBar(Integer.valueOf(-986896), 173, "menuBar"),
/*     */   
/* 247 */   MenuHighlight(Integer.valueOf(-13395457), 174, "menuHighlight");
/*     */   
/*     */   public final Color color;
/*     */   public final int nativeId;
/*     */   public final String ooxmlId;
/*     */   private static final Map<String, PresetColor> lookupOoxmlId;
/*     */   
/*     */   PresetColor(Integer paramInteger, int paramInt1, String paramString1) {
/* 255 */     this.color = (paramInteger == null) ? null : new Color(paramInteger.intValue(), true);
/* 256 */     this.nativeId = paramInt1;
/* 257 */     this.ooxmlId = paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 263 */     lookupOoxmlId = new HashMap<String, PresetColor>();
/* 264 */     for (PresetColor presetColor : values()) {
/* 265 */       if (presetColor.ooxmlId != null) {
/* 266 */         lookupOoxmlId.put(presetColor.ooxmlId, presetColor);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static PresetColor valueOfOoxmlId(String paramString) {
/* 272 */     return lookupOoxmlId.get(paramString);
/*     */   }
/*     */   
/*     */   public static PresetColor valueOfNativeId(int paramInt) {
/* 276 */     PresetColor[] arrayOfPresetColor = values();
/* 277 */     return (0 < paramInt && paramInt <= arrayOfPresetColor.length) ? arrayOfPresetColor[paramInt - 1] : null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PresetColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */