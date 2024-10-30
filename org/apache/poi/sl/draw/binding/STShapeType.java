/*      */ package org.apache.poi.sl.draw.binding;
/*      */ 
/*      */ import javax.xml.bind.annotation.XmlEnum;
/*      */ import javax.xml.bind.annotation.XmlEnumValue;
/*      */ import javax.xml.bind.annotation.XmlType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @XmlType(name = "ST_ShapeType", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*      */ @XmlEnum
/*      */ public enum STShapeType
/*      */ {
/*  234 */   LINE("line"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  241 */   LINE_INV("lineInv"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  248 */   TRIANGLE("triangle"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  255 */   RT_TRIANGLE("rtTriangle"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  262 */   RECT("rect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  269 */   DIAMOND("diamond"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  276 */   PARALLELOGRAM("parallelogram"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  283 */   TRAPEZOID("trapezoid"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  290 */   NON_ISOSCELES_TRAPEZOID("nonIsoscelesTrapezoid"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  297 */   PENTAGON("pentagon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  304 */   HEXAGON("hexagon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  311 */   HEPTAGON("heptagon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  318 */   OCTAGON("octagon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  325 */   DECAGON("decagon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  332 */   DODECAGON("dodecagon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  339 */   STAR_4("star4"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  346 */   STAR_5("star5"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  353 */   STAR_6("star6"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  360 */   STAR_7("star7"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  367 */   STAR_8("star8"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  374 */   STAR_10("star10"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  381 */   STAR_12("star12"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  388 */   STAR_16("star16"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  395 */   STAR_24("star24"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  402 */   STAR_32("star32"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  409 */   ROUND_RECT("roundRect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  416 */   ROUND_1_RECT("round1Rect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  423 */   ROUND_2_SAME_RECT("round2SameRect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  430 */   ROUND_2_DIAG_RECT("round2DiagRect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  437 */   SNIP_ROUND_RECT("snipRoundRect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  444 */   SNIP_1_RECT("snip1Rect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  451 */   SNIP_2_SAME_RECT("snip2SameRect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  458 */   SNIP_2_DIAG_RECT("snip2DiagRect"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  465 */   PLAQUE("plaque"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  472 */   ELLIPSE("ellipse"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  479 */   TEARDROP("teardrop"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  486 */   HOME_PLATE("homePlate"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  493 */   CHEVRON("chevron"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  500 */   PIE_WEDGE("pieWedge"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  507 */   PIE("pie"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  514 */   BLOCK_ARC("blockArc"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  521 */   DONUT("donut"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  528 */   NO_SMOKING("noSmoking"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  535 */   RIGHT_ARROW("rightArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  542 */   LEFT_ARROW("leftArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  549 */   UP_ARROW("upArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  556 */   DOWN_ARROW("downArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  563 */   STRIPED_RIGHT_ARROW("stripedRightArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  570 */   NOTCHED_RIGHT_ARROW("notchedRightArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  577 */   BENT_UP_ARROW("bentUpArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  584 */   LEFT_RIGHT_ARROW("leftRightArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  591 */   UP_DOWN_ARROW("upDownArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  598 */   LEFT_UP_ARROW("leftUpArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  605 */   LEFT_RIGHT_UP_ARROW("leftRightUpArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  612 */   QUAD_ARROW("quadArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  619 */   LEFT_ARROW_CALLOUT("leftArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  626 */   RIGHT_ARROW_CALLOUT("rightArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  633 */   UP_ARROW_CALLOUT("upArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  640 */   DOWN_ARROW_CALLOUT("downArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  647 */   LEFT_RIGHT_ARROW_CALLOUT("leftRightArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  654 */   UP_DOWN_ARROW_CALLOUT("upDownArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  661 */   QUAD_ARROW_CALLOUT("quadArrowCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  668 */   BENT_ARROW("bentArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  675 */   UTURN_ARROW("uturnArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  682 */   CIRCULAR_ARROW("circularArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  689 */   LEFT_CIRCULAR_ARROW("leftCircularArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  696 */   LEFT_RIGHT_CIRCULAR_ARROW("leftRightCircularArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  703 */   CURVED_RIGHT_ARROW("curvedRightArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  710 */   CURVED_LEFT_ARROW("curvedLeftArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  717 */   CURVED_UP_ARROW("curvedUpArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  724 */   CURVED_DOWN_ARROW("curvedDownArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  731 */   SWOOSH_ARROW("swooshArrow"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  738 */   CUBE("cube"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  745 */   CAN("can"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  752 */   LIGHTNING_BOLT("lightningBolt"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  759 */   HEART("heart"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  766 */   SUN("sun"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  773 */   MOON("moon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  780 */   SMILEY_FACE("smileyFace"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  787 */   IRREGULAR_SEAL_1("irregularSeal1"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  794 */   IRREGULAR_SEAL_2("irregularSeal2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  801 */   FOLDED_CORNER("foldedCorner"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  808 */   BEVEL("bevel"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  815 */   FRAME("frame"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  822 */   HALF_FRAME("halfFrame"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  829 */   CORNER("corner"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  836 */   DIAG_STRIPE("diagStripe"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  843 */   CHORD("chord"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  850 */   ARC("arc"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  857 */   LEFT_BRACKET("leftBracket"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  864 */   RIGHT_BRACKET("rightBracket"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  871 */   LEFT_BRACE("leftBrace"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  878 */   RIGHT_BRACE("rightBrace"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  885 */   BRACKET_PAIR("bracketPair"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  892 */   BRACE_PAIR("bracePair"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  899 */   STRAIGHT_CONNECTOR_1("straightConnector1"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  906 */   BENT_CONNECTOR_2("bentConnector2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  913 */   BENT_CONNECTOR_3("bentConnector3"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  920 */   BENT_CONNECTOR_4("bentConnector4"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  927 */   BENT_CONNECTOR_5("bentConnector5"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  934 */   CURVED_CONNECTOR_2("curvedConnector2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  941 */   CURVED_CONNECTOR_3("curvedConnector3"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  948 */   CURVED_CONNECTOR_4("curvedConnector4"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  955 */   CURVED_CONNECTOR_5("curvedConnector5"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  962 */   CALLOUT_1("callout1"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  969 */   CALLOUT_2("callout2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  976 */   CALLOUT_3("callout3"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  983 */   ACCENT_CALLOUT_1("accentCallout1"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  990 */   ACCENT_CALLOUT_2("accentCallout2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  997 */   ACCENT_CALLOUT_3("accentCallout3"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1004 */   BORDER_CALLOUT_1("borderCallout1"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1011 */   BORDER_CALLOUT_2("borderCallout2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1018 */   BORDER_CALLOUT_3("borderCallout3"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1025 */   ACCENT_BORDER_CALLOUT_1("accentBorderCallout1"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1032 */   ACCENT_BORDER_CALLOUT_2("accentBorderCallout2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1039 */   ACCENT_BORDER_CALLOUT_3("accentBorderCallout3"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1046 */   WEDGE_RECT_CALLOUT("wedgeRectCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1053 */   WEDGE_ROUND_RECT_CALLOUT("wedgeRoundRectCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1060 */   WEDGE_ELLIPSE_CALLOUT("wedgeEllipseCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1067 */   CLOUD_CALLOUT("cloudCallout"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1074 */   CLOUD("cloud"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1081 */   RIBBON("ribbon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1088 */   RIBBON_2("ribbon2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1095 */   ELLIPSE_RIBBON("ellipseRibbon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1102 */   ELLIPSE_RIBBON_2("ellipseRibbon2"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1109 */   LEFT_RIGHT_RIBBON("leftRightRibbon"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1116 */   VERTICAL_SCROLL("verticalScroll"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1123 */   HORIZONTAL_SCROLL("horizontalScroll"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1130 */   WAVE("wave"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1137 */   DOUBLE_WAVE("doubleWave"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1144 */   PLUS("plus"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1151 */   FLOW_CHART_PROCESS("flowChartProcess"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1158 */   FLOW_CHART_DECISION("flowChartDecision"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1165 */   FLOW_CHART_INPUT_OUTPUT("flowChartInputOutput"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1172 */   FLOW_CHART_PREDEFINED_PROCESS("flowChartPredefinedProcess"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1179 */   FLOW_CHART_INTERNAL_STORAGE("flowChartInternalStorage"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1186 */   FLOW_CHART_DOCUMENT("flowChartDocument"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1193 */   FLOW_CHART_MULTIDOCUMENT("flowChartMultidocument"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1200 */   FLOW_CHART_TERMINATOR("flowChartTerminator"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1207 */   FLOW_CHART_PREPARATION("flowChartPreparation"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1214 */   FLOW_CHART_MANUAL_INPUT("flowChartManualInput"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1221 */   FLOW_CHART_MANUAL_OPERATION("flowChartManualOperation"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1228 */   FLOW_CHART_CONNECTOR("flowChartConnector"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1235 */   FLOW_CHART_PUNCHED_CARD("flowChartPunchedCard"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1242 */   FLOW_CHART_PUNCHED_TAPE("flowChartPunchedTape"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1249 */   FLOW_CHART_SUMMING_JUNCTION("flowChartSummingJunction"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1256 */   FLOW_CHART_OR("flowChartOr"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1263 */   FLOW_CHART_COLLATE("flowChartCollate"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1270 */   FLOW_CHART_SORT("flowChartSort"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1277 */   FLOW_CHART_EXTRACT("flowChartExtract"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1284 */   FLOW_CHART_MERGE("flowChartMerge"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1291 */   FLOW_CHART_OFFLINE_STORAGE("flowChartOfflineStorage"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1298 */   FLOW_CHART_ONLINE_STORAGE("flowChartOnlineStorage"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1305 */   FLOW_CHART_MAGNETIC_TAPE("flowChartMagneticTape"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1312 */   FLOW_CHART_MAGNETIC_DISK("flowChartMagneticDisk"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1319 */   FLOW_CHART_MAGNETIC_DRUM("flowChartMagneticDrum"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1326 */   FLOW_CHART_DISPLAY("flowChartDisplay"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1333 */   FLOW_CHART_DELAY("flowChartDelay"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1340 */   FLOW_CHART_ALTERNATE_PROCESS("flowChartAlternateProcess"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1347 */   FLOW_CHART_OFFPAGE_CONNECTOR("flowChartOffpageConnector"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1354 */   ACTION_BUTTON_BLANK("actionButtonBlank"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1361 */   ACTION_BUTTON_HOME("actionButtonHome"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1368 */   ACTION_BUTTON_HELP("actionButtonHelp"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1375 */   ACTION_BUTTON_INFORMATION("actionButtonInformation"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1382 */   ACTION_BUTTON_FORWARD_NEXT("actionButtonForwardNext"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1389 */   ACTION_BUTTON_BACK_PREVIOUS("actionButtonBackPrevious"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1396 */   ACTION_BUTTON_END("actionButtonEnd"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1403 */   ACTION_BUTTON_BEGINNING("actionButtonBeginning"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1410 */   ACTION_BUTTON_RETURN("actionButtonReturn"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1417 */   ACTION_BUTTON_DOCUMENT("actionButtonDocument"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1424 */   ACTION_BUTTON_SOUND("actionButtonSound"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1431 */   ACTION_BUTTON_MOVIE("actionButtonMovie"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1438 */   GEAR_6("gear6"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1445 */   GEAR_9("gear9"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1452 */   FUNNEL("funnel"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1459 */   MATH_PLUS("mathPlus"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1466 */   MATH_MINUS("mathMinus"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1473 */   MATH_MULTIPLY("mathMultiply"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1480 */   MATH_DIVIDE("mathDivide"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1487 */   MATH_EQUAL("mathEqual"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1494 */   MATH_NOT_EQUAL("mathNotEqual"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1501 */   CORNER_TABS("cornerTabs"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1508 */   SQUARE_TABS("squareTabs"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1515 */   PLAQUE_TABS("plaqueTabs"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1522 */   CHART_X("chartX"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1529 */   CHART_STAR("chartStar"),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1536 */   CHART_PLUS("chartPlus");
/*      */   
/*      */   private final String value;
/*      */   
/*      */   STShapeType(String paramString1) {
/* 1541 */     this.value = paramString1;
/*      */   }
/*      */   
/*      */   public String value() {
/* 1545 */     return this.value;
/*      */   }
/*      */   
/*      */   public static STShapeType fromValue(String paramString) {
/* 1549 */     for (STShapeType sTShapeType : values()) {
/* 1550 */       if (sTShapeType.value.equals(paramString)) {
/* 1551 */         return sTShapeType;
/*      */       }
/*      */     } 
/* 1554 */     throw new IllegalArgumentException(paramString);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\STShapeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */