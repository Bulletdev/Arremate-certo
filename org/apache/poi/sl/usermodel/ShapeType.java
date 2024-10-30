/*     */ package org.apache.poi.sl.usermodel;
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
/*     */ public enum ShapeType
/*     */ {
/*  24 */   NOT_PRIMITIVE(-1, 0, "NotPrimitive"),
/*  25 */   LINE(1, 20, "Line"),
/*  26 */   LINE_INV(2, -1, null),
/*  27 */   TRIANGLE(3, 5, "IsocelesTriangle"),
/*  28 */   RT_TRIANGLE(4, 6, "RightTriangle"),
/*  29 */   RECT(5, 1, "Rectangle"),
/*  30 */   DIAMOND(6, 4, "Diamond"),
/*  31 */   PARALLELOGRAM(7, 7, "Parallelogram"),
/*  32 */   TRAPEZOID(8, 8, "Trapezoid"),
/*  33 */   NON_ISOSCELES_TRAPEZOID(9, -1, null),
/*  34 */   PENTAGON(10, 56, "Pentagon"),
/*  35 */   HEXAGON(11, 9, "Hexagon"),
/*  36 */   HEPTAGON(12, -1, null),
/*  37 */   OCTAGON(13, 10, "Octagon"),
/*  38 */   DECAGON(14, -1, null),
/*  39 */   DODECAGON(15, -1, null),
/*  40 */   STAR_4(16, 187, "Star4"),
/*  41 */   STAR_5(17, 12, "Star"),
/*  42 */   STAR_6(18, -1, null),
/*  43 */   STAR_7(19, -1, null),
/*  44 */   STAR_8(20, 58, "Star8"),
/*  45 */   STAR_10(21, -1, null),
/*  46 */   STAR_12(22, -1, null),
/*  47 */   STAR_16(23, 59, "Star16"),
/*  48 */   SEAL(23, 18, "Seal"),
/*  49 */   STAR_24(24, 92, "Star24"),
/*  50 */   STAR_32(25, 60, "Star32"),
/*  51 */   ROUND_RECT(26, 2, "RoundRectangle"),
/*  52 */   ROUND_1_RECT(27, -1, null),
/*  53 */   ROUND_2_SAME_RECT(28, -1, null),
/*  54 */   ROUND_2_DIAG_RECT(29, -1, null),
/*  55 */   SNIP_ROUND_RECT(30, -1, null),
/*  56 */   SNIP_1_RECT(31, -1, null),
/*  57 */   SNIP_2_SAME_RECT(32, -1, null),
/*  58 */   SNIP_2_DIAG_RECT(33, -1, null),
/*  59 */   PLAQUE(34, 21, "Plaque"),
/*  60 */   ELLIPSE(35, 3, "Ellipse"),
/*  61 */   TEARDROP(36, -1, null),
/*  62 */   HOME_PLATE(37, 15, "HomePlate"),
/*  63 */   CHEVRON(38, 55, "Chevron"),
/*  64 */   PIE_WEDGE(39, -1, null),
/*  65 */   PIE(40, -1, null),
/*  66 */   BLOCK_ARC(41, 95, "BlockArc"),
/*  67 */   DONUT(42, 23, "Donut"),
/*  68 */   NO_SMOKING(43, 57, "NoSmoking"),
/*  69 */   RIGHT_ARROW(44, 13, "Arrow"),
/*  70 */   LEFT_ARROW(45, 66, "LeftArrow"),
/*  71 */   UP_ARROW(46, 68, "UpArrow"),
/*  72 */   DOWN_ARROW(47, 67, "DownArrow"),
/*  73 */   STRIPED_RIGHT_ARROW(48, 93, "StripedRightArrow"),
/*  74 */   NOTCHED_RIGHT_ARROW(49, 94, "NotchedRightArrow"),
/*  75 */   BENT_UP_ARROW(50, 90, "BentUpArrow"),
/*  76 */   LEFT_RIGHT_ARROW(51, 69, "LeftRightArrow"),
/*  77 */   UP_DOWN_ARROW(52, 70, "UpDownArrow"),
/*  78 */   LEFT_UP_ARROW(53, 89, "LeftUpArrow"),
/*  79 */   LEFT_RIGHT_UP_ARROW(54, 182, "LeftRightUpArrow"),
/*  80 */   QUAD_ARROW(55, 76, "QuadArrow"),
/*  81 */   LEFT_ARROW_CALLOUT(56, 77, "LeftArrowCallout"),
/*  82 */   RIGHT_ARROW_CALLOUT(57, 78, "RightArrowCallout"),
/*  83 */   UP_ARROW_CALLOUT(58, 79, "UpArrowCallout"),
/*  84 */   DOWN_ARROW_CALLOUT(59, 80, "DownArrowCallout"),
/*  85 */   LEFT_RIGHT_ARROW_CALLOUT(60, 81, "LeftRightArrowCallout"),
/*  86 */   UP_DOWN_ARROW_CALLOUT(61, 82, "UpDownArrowCallout"),
/*  87 */   QUAD_ARROW_CALLOUT(62, 83, "QuadArrowCallout"),
/*  88 */   BENT_ARROW(63, 91, "BentArrow"),
/*  89 */   UTURN_ARROW(64, 101, "UturnArrow"),
/*  90 */   CIRCULAR_ARROW(65, 99, "CircularArrow"),
/*  91 */   LEFT_CIRCULAR_ARROW(66, -1, null),
/*  92 */   LEFT_RIGHT_CIRCULAR_ARROW(67, -1, null),
/*  93 */   CURVED_RIGHT_ARROW(68, 102, "CurvedRightArrow"),
/*  94 */   CURVED_LEFT_ARROW(69, 103, "CurvedLeftArrow"),
/*  95 */   CURVED_UP_ARROW(70, 104, "CurvedUpArrow"),
/*  96 */   CURVED_DOWN_ARROW(71, 105, "CurvedDownArrow"),
/*  97 */   SWOOSH_ARROW(72, -1, null),
/*  98 */   CUBE(73, 16, "Cube"),
/*  99 */   CAN(74, 22, "Can"),
/* 100 */   LIGHTNING_BOLT(75, 73, "LightningBolt"),
/* 101 */   HEART(76, 74, "Heart"),
/* 102 */   SUN(77, 183, "Sun"),
/* 103 */   MOON(78, 184, "Moon"),
/* 104 */   SMILEY_FACE(79, 96, "SmileyFace"),
/* 105 */   IRREGULAR_SEAL_1(80, 71, "IrregularSeal1"),
/* 106 */   IRREGULAR_SEAL_2(81, 72, "IrregularSeal2"),
/* 107 */   FOLDED_CORNER(82, 65, "FoldedCorner"),
/* 108 */   BEVEL(83, 84, "Bevel"),
/* 109 */   FRAME(84, 75, "PictureFrame"),
/* 110 */   HALF_FRAME(85, -1, null),
/* 111 */   CORNER(86, -1, null),
/* 112 */   DIAG_STRIPE(87, -1, null),
/* 113 */   CHORD(88, -1, null),
/* 114 */   ARC(89, 19, "Arc"),
/* 115 */   LEFT_BRACKET(90, 85, "LeftBracket"),
/* 116 */   RIGHT_BRACKET(91, 86, "RightBracket"),
/* 117 */   LEFT_BRACE(92, 87, "LeftBrace"),
/* 118 */   RIGHT_BRACE(93, 88, "RightBrace"),
/* 119 */   BRACKET_PAIR(94, 185, "BracketPair"),
/* 120 */   BRACE_PAIR(95, 186, "BracePair"),
/* 121 */   STRAIGHT_CONNECTOR_1(96, 32, "StraightConnector1"),
/* 122 */   BENT_CONNECTOR_2(97, 33, "BentConnector2"),
/* 123 */   BENT_CONNECTOR_3(98, 34, "BentConnector3"),
/* 124 */   BENT_CONNECTOR_4(99, 35, "BentConnector4"),
/* 125 */   BENT_CONNECTOR_5(100, 36, "BentConnector5"),
/* 126 */   CURVED_CONNECTOR_2(101, 37, "CurvedConnector2"),
/* 127 */   CURVED_CONNECTOR_3(102, 38, "CurvedConnector3"),
/* 128 */   CURVED_CONNECTOR_4(103, 39, "CurvedConnector4"),
/* 129 */   CURVED_CONNECTOR_5(104, 40, "CurvedConnector5"),
/* 130 */   CALLOUT_1(105, 41, "Callout1"),
/* 131 */   CALLOUT_2(106, 42, "Callout2"),
/* 132 */   CALLOUT_3(107, 43, "Callout3"),
/* 133 */   ACCENT_CALLOUT_1(108, 44, "AccentCallout1"),
/* 134 */   ACCENT_CALLOUT_2(109, 45, "AccentCallout2"),
/* 135 */   ACCENT_CALLOUT_3(110, 46, "AccentCallout3"),
/* 136 */   BORDER_CALLOUT_1(111, 47, "BorderCallout1"),
/* 137 */   BORDER_CALLOUT_2(112, 48, "BorderCallout2"),
/* 138 */   BORDER_CALLOUT_3(113, 49, "BorderCallout3"),
/* 139 */   ACCENT_BORDER_CALLOUT_1(114, 50, "AccentBorderCallout1"),
/* 140 */   ACCENT_BORDER_CALLOUT_2(115, 51, "AccentBorderCallout2"),
/* 141 */   ACCENT_BORDER_CALLOUT_3(116, 52, "AccentBorderCallout3"),
/* 142 */   WEDGE_RECT_CALLOUT(117, 61, "WedgeRectCallout"),
/* 143 */   WEDGE_ROUND_RECT_CALLOUT(118, 62, "WedgeRRectCallout"),
/* 144 */   WEDGE_ELLIPSE_CALLOUT(119, 63, "WedgeEllipseCallout"),
/* 145 */   CLOUD_CALLOUT(120, 106, "CloudCallout"),
/* 146 */   CLOUD(121, -1, null),
/* 147 */   RIBBON(122, 53, "Ribbon"),
/* 148 */   RIBBON_2(123, 54, "Ribbon2"),
/* 149 */   ELLIPSE_RIBBON(124, 107, "EllipseRibbon"),
/* 150 */   ELLIPSE_RIBBON_2(125, 108, "EllipseRibbon2"),
/* 151 */   LEFT_RIGHT_RIBBON(126, -1, null),
/* 152 */   VERTICAL_SCROLL(127, 97, "VerticalScroll"),
/* 153 */   HORIZONTAL_SCROLL(128, 98, "HorizontalScroll"),
/* 154 */   WAVE(129, 64, "Wave"),
/* 155 */   DOUBLE_WAVE(130, 188, "DoubleWave"),
/* 156 */   PLUS(131, 11, "Plus"),
/* 157 */   FLOW_CHART_PROCESS(132, 109, "FlowChartProcess"),
/* 158 */   FLOW_CHART_DECISION(133, 110, "FlowChartDecision"),
/* 159 */   FLOW_CHART_INPUT_OUTPUT(134, 111, "FlowChartInputOutput"),
/* 160 */   FLOW_CHART_PREDEFINED_PROCESS(135, 112, "FlowChartPredefinedProcess"),
/* 161 */   FLOW_CHART_INTERNAL_STORAGE(136, 113, "FlowChartInternalStorage"),
/* 162 */   FLOW_CHART_DOCUMENT(137, 114, "FlowChartDocument"),
/* 163 */   FLOW_CHART_MULTIDOCUMENT(138, 115, "FlowChartMultidocument"),
/* 164 */   FLOW_CHART_TERMINATOR(139, 116, "FlowChartTerminator"),
/* 165 */   FLOW_CHART_PREPARATION(140, 117, "FlowChartPreparation"),
/* 166 */   FLOW_CHART_MANUAL_INPUT(141, 118, "FlowChartManualInput"),
/* 167 */   FLOW_CHART_MANUAL_OPERATION(142, 119, "FlowChartManualOperation"),
/* 168 */   FLOW_CHART_CONNECTOR(143, 120, "FlowChartConnector"),
/* 169 */   FLOW_CHART_PUNCHED_CARD(144, 121, "FlowChartPunchedCard"),
/* 170 */   FLOW_CHART_PUNCHED_TAPE(145, 122, "FlowChartPunchedTape"),
/* 171 */   FLOW_CHART_SUMMING_JUNCTION(146, 123, "FlowChartSummingJunction"),
/* 172 */   FLOW_CHART_OR(147, 124, "FlowChartOr"),
/* 173 */   FLOW_CHART_COLLATE(148, 125, "FlowChartCollate"),
/* 174 */   FLOW_CHART_SORT(149, 126, "FlowChartSort"),
/* 175 */   FLOW_CHART_EXTRACT(150, 127, "FlowChartExtract"),
/* 176 */   FLOW_CHART_MERGE(151, 128, "FlowChartMerge"),
/* 177 */   FLOW_CHART_OFFLINE_STORAGE(152, 129, "FlowChartOfflineStorage"),
/* 178 */   FLOW_CHART_ONLINE_STORAGE(153, 130, "FlowChartOnlineStorage"),
/* 179 */   FLOW_CHART_MAGNETIC_TAPE(154, 131, "FlowChartMagneticTape"),
/* 180 */   FLOW_CHART_MAGNETIC_DISK(155, 132, "FlowChartMagneticDisk"),
/* 181 */   FLOW_CHART_MAGNETIC_DRUM(156, 133, "FlowChartMagneticDrum"),
/* 182 */   FLOW_CHART_DISPLAY(157, 134, "FlowChartDisplay"),
/* 183 */   FLOW_CHART_DELAY(158, 135, "FlowChartDelay"),
/* 184 */   FLOW_CHART_ALTERNATE_PROCESS(159, 176, "FlowChartAlternateProcess"),
/* 185 */   FLOW_CHART_OFFPAGE_CONNECTOR(160, 177, "FlowChartOffpageConnector"),
/* 186 */   ACTION_BUTTON_BLANK(161, 189, "ActionButtonBlank"),
/* 187 */   ACTION_BUTTON_HOME(162, 190, "ActionButtonHome"),
/* 188 */   ACTION_BUTTON_HELP(163, 191, "ActionButtonHelp"),
/* 189 */   ACTION_BUTTON_INFORMATION(164, 192, "ActionButtonInformation"),
/* 190 */   ACTION_BUTTON_FORWARD_NEXT(165, 193, "ActionButtonForwardNext"),
/* 191 */   ACTION_BUTTON_BACK_PREVIOUS(166, 194, "ActionButtonBackPrevious"),
/* 192 */   ACTION_BUTTON_END(167, 195, "ActionButtonEnd"),
/* 193 */   ACTION_BUTTON_BEGINNING(168, 196, "ActionButtonBeginning"),
/* 194 */   ACTION_BUTTON_RETURN(169, 197, "ActionButtonReturn"),
/* 195 */   ACTION_BUTTON_DOCUMENT(170, 198, "ActionButtonDocument"),
/* 196 */   ACTION_BUTTON_SOUND(171, 199, "ActionButtonSound"),
/* 197 */   ACTION_BUTTON_MOVIE(172, 200, "ActionButtonMovie"),
/* 198 */   GEAR_6(173, -1, null),
/* 199 */   GEAR_9(174, -1, null),
/* 200 */   FUNNEL(175, -1, null),
/* 201 */   MATH_PLUS(176, -1, null),
/* 202 */   MATH_MINUS(177, -1, null),
/* 203 */   MATH_MULTIPLY(178, -1, null),
/* 204 */   MATH_DIVIDE(179, -1, null),
/* 205 */   MATH_EQUAL(180, -1, null),
/* 206 */   MATH_NOT_EQUAL(181, -1, null),
/* 207 */   CORNER_TABS(182, -1, null),
/* 208 */   SQUARE_TABS(183, -1, null),
/* 209 */   PLAQUE_TABS(184, -1, null),
/* 210 */   CHART_X(185, -1, null),
/* 211 */   CHART_STAR(186, -1, null),
/* 212 */   CHART_PLUS(187, -1, null),
/*     */   
/* 214 */   NOTCHED_CIRCULAR_ARROW(-1, 100, "NotchedCircularArrow"),
/* 215 */   THICK_ARROW(-1, 14, "ThickArrow"),
/* 216 */   BALLOON(-1, 17, "Balloon"),
/* 217 */   TEXT_SIMPLE(-1, 24, "TextSimple"),
/* 218 */   TEXT_OCTAGON(-1, 25, "TextOctagon"),
/* 219 */   TEXT_HEXAGON(-1, 26, "TextHexagon"),
/* 220 */   TEXT_CURVE(-1, 27, "TextCurve"),
/* 221 */   TEXT_WAVE(-1, 28, "TextWave"),
/* 222 */   TEXT_RING(-1, 29, "TextRing"),
/* 223 */   TEXT_ON_CURVE(-1, 30, "TextOnCurve"),
/* 224 */   TEXT_ON_RING(-1, 31, "TextOnRing"),
/* 225 */   TEXT_PLAIN_TEXT(-1, 136, "TextPlainText"),
/* 226 */   TEXT_STOP(-1, 137, "TextStop"),
/* 227 */   TEXT_TRIANGLE(-1, 138, "TextTriangle"),
/* 228 */   TEXT_TRIANGLE_INVERTED(-1, 139, "TextTriangleInverted"),
/* 229 */   TEXT_CHEVRON(-1, 140, "TextChevron"),
/* 230 */   TEXT_CHEVRON_INVERTED(-1, 141, "TextChevronInverted"),
/* 231 */   TEXT_RING_INSIDE(-1, 142, "TextRingInside"),
/* 232 */   TEXT_RING_OUTSIDE(-1, 143, "TextRingOutside"),
/* 233 */   TEXT_ARCH_UP_CURVE(-1, 144, "TextArchUpCurve"),
/* 234 */   TEXT_ARCH_DOWN_CURVE(-1, 145, "TextArchDownCurve"),
/* 235 */   TEXT_CIRCLE_CURVE(-1, 146, "TextCircleCurve"),
/* 236 */   TEXT_BUTTON_CURVE(-1, 147, "TextButtonCurve"),
/* 237 */   TEXT_ARCH_UP_POUR(-1, 148, "TextArchUpPour"),
/* 238 */   TEXT_ARCH_DOWN_POUR(-1, 149, "TextArchDownPour"),
/* 239 */   TEXT_CIRCLE_POUR(-1, 150, "TextCirclePour"),
/* 240 */   TEXT_BUTTON_POUR(-1, 151, "TextButtonPour"),
/* 241 */   TEXT_CURVE_UP(-1, 152, "TextCurveUp"),
/* 242 */   TEXT_CURVE_DOWN(-1, 153, "TextCurveDown"),
/* 243 */   TEXT_CASCADE_UP(-1, 154, "TextCascadeUp"),
/* 244 */   TEXT_CASCADE_DOWN(-1, 155, "TextCascadeDown"),
/* 245 */   TEXT_WAVE_1(-1, 156, "TextWave1"),
/* 246 */   TEXT_WAVE_2(-1, 157, "TextWave2"),
/* 247 */   TEXT_WAVE_3(-1, 158, "TextWave3"),
/* 248 */   TEXT_WAVE_4(-1, 159, "TextWave4"),
/* 249 */   TEXT_INFLATE(-1, 160, "TextInflate"),
/* 250 */   TEXT_DEFLATE(-1, 161, "TextDeflate"),
/* 251 */   TEXT_INFLATE_BOTTOM(-1, 162, "TextInflateBottom"),
/* 252 */   TEXT_DEFLATE_BOTTOM(-1, 163, "TextDeflateBottom"),
/* 253 */   TEXT_INFLATE_TOP(-1, 164, "TextInflateTop"),
/* 254 */   TEXT_DEFLATE_TOP(-1, 165, "TextDeflateTop"),
/* 255 */   TEXT_DEFLATE_INFLATE(-1, 166, "TextDeflateInflate"),
/* 256 */   TEXT_DEFLATE_INFLATE_DEFLATE(-1, 167, "TextDeflateInflateDeflate"),
/* 257 */   TEXT_FADE_RIGHT(-1, 168, "TextFadeRight"),
/* 258 */   TEXT_FADE_LEFT(-1, 169, "TextFadeLeft"),
/* 259 */   TEXT_FADE_UP(-1, 170, "TextFadeUp"),
/* 260 */   TEXT_FADE_DOWN(-1, 171, "TextFadeDown"),
/* 261 */   TEXT_SLANT_UP(-1, 172, "TextSlantUp"),
/* 262 */   TEXT_SLANT_DOWN(-1, 173, "TextSlantDown"),
/* 263 */   TEXT_CAN_UP(-1, 174, "TextCanUp"),
/* 264 */   TEXT_CAN_DOWN(-1, 175, "TextCanDown"),
/* 265 */   CALLOUT_90(-1, 178, "Callout90"),
/* 266 */   ACCENT_CALLOUT_90(-1, 179, "AccentCallout90"),
/* 267 */   BORDER_CALLOUT_90(-1, 180, "BorderCallout90"),
/* 268 */   ACCENT_BORDER_CALLOUT_90(-1, 181, "AccentBorderCallout90"),
/* 269 */   HOST_CONTROL(-1, 201, "HostControl"),
/* 270 */   TEXT_BOX(-1, 202, "TextBox");
/*     */ 
/*     */   
/*     */   public final int ooxmlId;
/*     */ 
/*     */   
/*     */   public final int nativeId;
/*     */ 
/*     */   
/*     */   public final String nativeName;
/*     */ 
/*     */   
/*     */   ShapeType(int paramInt1, int paramInt2, String paramString1) {
/* 283 */     this.ooxmlId = paramInt1;
/* 284 */     this.nativeId = paramInt2;
/* 285 */     this.nativeName = paramString1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOoxmlName() {
/* 290 */     if (this == SEAL) return STAR_16.getOoxmlName(); 
/* 291 */     if (this.ooxmlId == -1) {
/* 292 */       return name().startsWith("TEXT") ? RECT.getOoxmlName() : null;
/*     */     }
/*     */     
/* 295 */     StringBuilder stringBuilder = new StringBuilder();
/* 296 */     boolean bool = true;
/* 297 */     for (char c : name().toCharArray()) {
/* 298 */       if (c == '_') {
/* 299 */         bool = false;
/*     */       } else {
/*     */         
/* 302 */         stringBuilder.append(bool ? Character.toLowerCase(c) : Character.toUpperCase(c));
/* 303 */         bool = true;
/*     */       } 
/*     */     } 
/* 306 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static ShapeType forId(int paramInt, boolean paramBoolean) {
/* 310 */     for (ShapeType shapeType : values()) {
/* 311 */       if ((paramBoolean && shapeType.ooxmlId == paramInt) || (!paramBoolean && shapeType.nativeId == paramInt))
/* 312 */         return shapeType; 
/*     */     } 
/* 314 */     throw new IllegalArgumentException("Unknown shape type: " + paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ShapeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */