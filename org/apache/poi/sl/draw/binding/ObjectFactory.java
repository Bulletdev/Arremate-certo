/*      */ package org.apache.poi.sl.draw.binding;
/*      */ 
/*      */ import javax.xml.bind.JAXBElement;
/*      */ import javax.xml.bind.annotation.XmlElementDecl;
/*      */ import javax.xml.bind.annotation.XmlRegistry;
/*      */ import javax.xml.namespace.b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @XmlRegistry
/*      */ public class ObjectFactory
/*      */ {
/*   43 */   private static final b _CTSRgbColorAlpha_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha");
/*   44 */   private static final b _CTSRgbColorLum_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lum");
/*   45 */   private static final b _CTSRgbColorGamma_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma");
/*   46 */   private static final b _CTSRgbColorInvGamma_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma");
/*   47 */   private static final b _CTSRgbColorRedOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff");
/*   48 */   private static final b _CTSRgbColorAlphaMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod");
/*   49 */   private static final b _CTSRgbColorAlphaOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff");
/*   50 */   private static final b _CTSRgbColorGreenOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff");
/*   51 */   private static final b _CTSRgbColorRedMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod");
/*   52 */   private static final b _CTSRgbColorHue_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hue");
/*   53 */   private static final b _CTSRgbColorSatOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff");
/*   54 */   private static final b _CTSRgbColorGreenMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod");
/*   55 */   private static final b _CTSRgbColorSat_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sat");
/*   56 */   private static final b _CTSRgbColorBlue_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blue");
/*   57 */   private static final b _CTSRgbColorRed_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "red");
/*   58 */   private static final b _CTSRgbColorSatMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod");
/*   59 */   private static final b _CTSRgbColorHueOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff");
/*   60 */   private static final b _CTSRgbColorBlueMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod");
/*   61 */   private static final b _CTSRgbColorShade_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "shade");
/*   62 */   private static final b _CTSRgbColorLumMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod");
/*   63 */   private static final b _CTSRgbColorInv_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "inv");
/*   64 */   private static final b _CTSRgbColorLumOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff");
/*   65 */   private static final b _CTSRgbColorTint_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tint");
/*   66 */   private static final b _CTSRgbColorGreen_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "green");
/*   67 */   private static final b _CTSRgbColorComp_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "comp");
/*   68 */   private static final b _CTSRgbColorBlueOff_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff");
/*   69 */   private static final b _CTSRgbColorHueMod_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod");
/*   70 */   private static final b _CTSRgbColorGray_QNAME = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gray");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPositiveSize2D createCTPositiveSize2D() {
/*   84 */     return new CTPositiveSize2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTSphereCoords createCTSphereCoords() {
/*   92 */     return new CTSphereCoords();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPositivePercentage createCTPositivePercentage() {
/*  100 */     return new CTPositivePercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTAdjPoint2D createCTAdjPoint2D() {
/*  108 */     return new CTAdjPoint2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DCubicBezierTo createCTPath2DCubicBezierTo() {
/*  116 */     return new CTPath2DCubicBezierTo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTEmbeddedWAVAudioFile createCTEmbeddedWAVAudioFile() {
/*  124 */     return new CTEmbeddedWAVAudioFile();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPresetGeometry2D createCTPresetGeometry2D() {
/*  132 */     return new CTPresetGeometry2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTSchemeColor createCTSchemeColor() {
/*  140 */     return new CTSchemeColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTInverseTransform createCTInverseTransform() {
/*  148 */     return new CTInverseTransform();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTScRgbColor createCTScRgbColor() {
/*  156 */     return new CTScRgbColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPositiveFixedAngle createCTPositiveFixedAngle() {
/*  164 */     return new CTPositiveFixedAngle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTInverseGammaTransform createCTInverseGammaTransform() {
/*  172 */     return new CTInverseGammaTransform();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTColorMRU createCTColorMRU() {
/*  180 */     return new CTColorMRU();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DArcTo createCTPath2DArcTo() {
/*  188 */     return new CTPath2DArcTo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTSystemColor createCTSystemColor() {
/*  196 */     return new CTSystemColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTGroupTransform2D createCTGroupTransform2D() {
/*  204 */     return new CTGroupTransform2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPoint2D createCTPoint2D() {
/*  212 */     return new CTPoint2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTGeomRect createCTGeomRect() {
/*  220 */     return new CTGeomRect();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTScale2D createCTScale2D() {
/*  228 */     return new CTScale2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTGeomGuide createCTGeomGuide() {
/*  236 */     return new CTGeomGuide();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTXYAdjustHandle createCTXYAdjustHandle() {
/*  244 */     return new CTXYAdjustHandle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTCustomGeometry2D createCTCustomGeometry2D() {
/*  252 */     return new CTCustomGeometry2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTOfficeArtExtension createCTOfficeArtExtension() {
/*  260 */     return new CTOfficeArtExtension();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTGrayscaleTransform createCTGrayscaleTransform() {
/*  268 */     return new CTGrayscaleTransform();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DClose createCTPath2DClose() {
/*  276 */     return new CTPath2DClose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTComplementTransform createCTComplementTransform() {
/*  284 */     return new CTComplementTransform();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPoint3D createCTPoint3D() {
/*  292 */     return new CTPoint3D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPositiveFixedPercentage createCTPositiveFixedPercentage() {
/*  300 */     return new CTPositiveFixedPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2D createCTPath2D() {
/*  308 */     return new CTPath2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTAdjustHandleList createCTAdjustHandleList() {
/*  316 */     return new CTAdjustHandleList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTConnectionSiteList createCTConnectionSiteList() {
/*  324 */     return new CTConnectionSiteList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPresetTextShape createCTPresetTextShape() {
/*  332 */     return new CTPresetTextShape();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTSRgbColor createCTSRgbColor() {
/*  340 */     return new CTSRgbColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DMoveTo createCTPath2DMoveTo() {
/*  348 */     return new CTPath2DMoveTo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTRelativeRect createCTRelativeRect() {
/*  356 */     return new CTRelativeRect();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DList createCTPath2DList() {
/*  364 */     return new CTPath2DList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPolarAdjustHandle createCTPolarAdjustHandle() {
/*  372 */     return new CTPolarAdjustHandle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPercentage createCTPercentage() {
/*  380 */     return new CTPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTHslColor createCTHslColor() {
/*  388 */     return new CTHslColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTRatio createCTRatio() {
/*  396 */     return new CTRatio();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTGeomGuideList createCTGeomGuideList() {
/*  404 */     return new CTGeomGuideList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTTransform2D createCTTransform2D() {
/*  412 */     return new CTTransform2D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTGammaTransform createCTGammaTransform() {
/*  420 */     return new CTGammaTransform();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DQuadBezierTo createCTPath2DQuadBezierTo() {
/*  428 */     return new CTPath2DQuadBezierTo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTAngle createCTAngle() {
/*  436 */     return new CTAngle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTConnectionSite createCTConnectionSite() {
/*  444 */     return new CTConnectionSite();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTHyperlink createCTHyperlink() {
/*  452 */     return new CTHyperlink();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTFixedPercentage createCTFixedPercentage() {
/*  460 */     return new CTFixedPercentage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPath2DLineTo createCTPath2DLineTo() {
/*  468 */     return new CTPath2DLineTo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTColor createCTColor() {
/*  476 */     return new CTColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTPresetColor createCTPresetColor() {
/*  484 */     return new CTPresetColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTVector3D createCTVector3D() {
/*  492 */     return new CTVector3D();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTOfficeArtExtensionList createCTOfficeArtExtensionList() {
/*  500 */     return new CTOfficeArtExtensionList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CTConnection createCTConnection() {
/*  508 */     return new CTConnection();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alpha", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSRgbColorAlpha(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/*  517 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTSRgbColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lum", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorLum(CTPercentage paramCTPercentage) {
/*  526 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gamma", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTGammaTransform> createCTSRgbColorGamma(CTGammaTransform paramCTGammaTransform) {
/*  535 */     return new JAXBElement<CTGammaTransform>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTSRgbColor.class, paramCTGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "invGamma", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTInverseGammaTransform> createCTSRgbColorInvGamma(CTInverseGammaTransform paramCTInverseGammaTransform) {
/*  544 */     return new JAXBElement<CTInverseGammaTransform>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTSRgbColor.class, paramCTInverseGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorRedOff(CTPercentage paramCTPercentage) {
/*  553 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTSRgbColorAlphaMod(CTPositivePercentage paramCTPositivePercentage) {
/*  562 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTSRgbColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTFixedPercentage> createCTSRgbColorAlphaOff(CTFixedPercentage paramCTFixedPercentage) {
/*  571 */     return new JAXBElement<CTFixedPercentage>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTSRgbColor.class, paramCTFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorGreenOff(CTPercentage paramCTPercentage) {
/*  580 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorRedMod(CTPercentage paramCTPercentage) {
/*  589 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hue", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedAngle> createCTSRgbColorHue(CTPositiveFixedAngle paramCTPositiveFixedAngle) {
/*  598 */     return new JAXBElement<CTPositiveFixedAngle>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTSRgbColor.class, paramCTPositiveFixedAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorSatOff(CTPercentage paramCTPercentage) {
/*  607 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorGreenMod(CTPercentage paramCTPercentage) {
/*  616 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "sat", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorSat(CTPercentage paramCTPercentage) {
/*  625 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blue", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorBlue(CTPercentage paramCTPercentage) {
/*  634 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "red", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorRed(CTPercentage paramCTPercentage) {
/*  643 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorSatMod(CTPercentage paramCTPercentage) {
/*  652 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTAngle> createCTSRgbColorHueOff(CTAngle paramCTAngle) {
/*  661 */     return new JAXBElement<CTAngle>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTSRgbColor.class, paramCTAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorBlueMod(CTPercentage paramCTPercentage) {
/*  670 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "shade", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSRgbColorShade(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/*  679 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTSRgbColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorLumMod(CTPercentage paramCTPercentage) {
/*  688 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "inv", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTInverseTransform> createCTSRgbColorInv(CTInverseTransform paramCTInverseTransform) {
/*  697 */     return new JAXBElement<CTInverseTransform>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTSRgbColor.class, paramCTInverseTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorLumOff(CTPercentage paramCTPercentage) {
/*  706 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "tint", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSRgbColorTint(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/*  715 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTSRgbColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "green", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorGreen(CTPercentage paramCTPercentage) {
/*  724 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "comp", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTComplementTransform> createCTSRgbColorComp(CTComplementTransform paramCTComplementTransform) {
/*  733 */     return new JAXBElement<CTComplementTransform>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTSRgbColor.class, paramCTComplementTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueOff", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSRgbColorBlueOff(CTPercentage paramCTPercentage) {
/*  742 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTSRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueMod", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTSRgbColorHueMod(CTPositivePercentage paramCTPositivePercentage) {
/*  751 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTSRgbColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gray", scope = CTSRgbColor.class)
/*      */   public JAXBElement<CTGrayscaleTransform> createCTSRgbColorGray(CTGrayscaleTransform paramCTGrayscaleTransform) {
/*  760 */     return new JAXBElement<CTGrayscaleTransform>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTSRgbColor.class, paramCTGrayscaleTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lum", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorLum(CTPercentage paramCTPercentage) {
/*  769 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alpha", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSystemColorAlpha(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/*  778 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTSystemColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gamma", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTGammaTransform> createCTSystemColorGamma(CTGammaTransform paramCTGammaTransform) {
/*  787 */     return new JAXBElement<CTGammaTransform>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTSystemColor.class, paramCTGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "invGamma", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTInverseGammaTransform> createCTSystemColorInvGamma(CTInverseGammaTransform paramCTInverseGammaTransform) {
/*  796 */     return new JAXBElement<CTInverseGammaTransform>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTSystemColor.class, paramCTInverseGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTSystemColorAlphaMod(CTPositivePercentage paramCTPositivePercentage) {
/*  805 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTSystemColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorRedOff(CTPercentage paramCTPercentage) {
/*  814 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTFixedPercentage> createCTSystemColorAlphaOff(CTFixedPercentage paramCTFixedPercentage) {
/*  823 */     return new JAXBElement<CTFixedPercentage>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTSystemColor.class, paramCTFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorGreenOff(CTPercentage paramCTPercentage) {
/*  832 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorRedMod(CTPercentage paramCTPercentage) {
/*  841 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hue", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPositiveFixedAngle> createCTSystemColorHue(CTPositiveFixedAngle paramCTPositiveFixedAngle) {
/*  850 */     return new JAXBElement<CTPositiveFixedAngle>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTSystemColor.class, paramCTPositiveFixedAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorSatOff(CTPercentage paramCTPercentage) {
/*  859 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorGreenMod(CTPercentage paramCTPercentage) {
/*  868 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blue", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorBlue(CTPercentage paramCTPercentage) {
/*  877 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "sat", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorSat(CTPercentage paramCTPercentage) {
/*  886 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "red", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorRed(CTPercentage paramCTPercentage) {
/*  895 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorSatMod(CTPercentage paramCTPercentage) {
/*  904 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorBlueMod(CTPercentage paramCTPercentage) {
/*  913 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTAngle> createCTSystemColorHueOff(CTAngle paramCTAngle) {
/*  922 */     return new JAXBElement<CTAngle>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTSystemColor.class, paramCTAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "shade", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSystemColorShade(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/*  931 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTSystemColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorLumMod(CTPercentage paramCTPercentage) {
/*  940 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "inv", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTInverseTransform> createCTSystemColorInv(CTInverseTransform paramCTInverseTransform) {
/*  949 */     return new JAXBElement<CTInverseTransform>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTSystemColor.class, paramCTInverseTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorLumOff(CTPercentage paramCTPercentage) {
/*  958 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "tint", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSystemColorTint(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/*  967 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTSystemColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "green", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorGreen(CTPercentage paramCTPercentage) {
/*  976 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "comp", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTComplementTransform> createCTSystemColorComp(CTComplementTransform paramCTComplementTransform) {
/*  985 */     return new JAXBElement<CTComplementTransform>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTSystemColor.class, paramCTComplementTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueOff", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSystemColorBlueOff(CTPercentage paramCTPercentage) {
/*  994 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTSystemColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueMod", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTSystemColorHueMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1003 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTSystemColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gray", scope = CTSystemColor.class)
/*      */   public JAXBElement<CTGrayscaleTransform> createCTSystemColorGray(CTGrayscaleTransform paramCTGrayscaleTransform) {
/* 1012 */     return new JAXBElement<CTGrayscaleTransform>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTSystemColor.class, paramCTGrayscaleTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lum", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorLum(CTPercentage paramCTPercentage) {
/* 1021 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alpha", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSchemeColorAlpha(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1030 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTSchemeColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gamma", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTGammaTransform> createCTSchemeColorGamma(CTGammaTransform paramCTGammaTransform) {
/* 1039 */     return new JAXBElement<CTGammaTransform>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTSchemeColor.class, paramCTGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "invGamma", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTInverseGammaTransform> createCTSchemeColorInvGamma(CTInverseGammaTransform paramCTInverseGammaTransform) {
/* 1048 */     return new JAXBElement<CTInverseGammaTransform>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTSchemeColor.class, paramCTInverseGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorRedOff(CTPercentage paramCTPercentage) {
/* 1057 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTSchemeColorAlphaMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1066 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTSchemeColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTFixedPercentage> createCTSchemeColorAlphaOff(CTFixedPercentage paramCTFixedPercentage) {
/* 1075 */     return new JAXBElement<CTFixedPercentage>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTSchemeColor.class, paramCTFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorGreenOff(CTPercentage paramCTPercentage) {
/* 1084 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hue", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPositiveFixedAngle> createCTSchemeColorHue(CTPositiveFixedAngle paramCTPositiveFixedAngle) {
/* 1093 */     return new JAXBElement<CTPositiveFixedAngle>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTSchemeColor.class, paramCTPositiveFixedAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorRedMod(CTPercentage paramCTPercentage) {
/* 1102 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorSatOff(CTPercentage paramCTPercentage) {
/* 1111 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorGreenMod(CTPercentage paramCTPercentage) {
/* 1120 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blue", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorBlue(CTPercentage paramCTPercentage) {
/* 1129 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "sat", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorSat(CTPercentage paramCTPercentage) {
/* 1138 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "red", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorRed(CTPercentage paramCTPercentage) {
/* 1147 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorSatMod(CTPercentage paramCTPercentage) {
/* 1156 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTAngle> createCTSchemeColorHueOff(CTAngle paramCTAngle) {
/* 1165 */     return new JAXBElement<CTAngle>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTSchemeColor.class, paramCTAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorBlueMod(CTPercentage paramCTPercentage) {
/* 1174 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "shade", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSchemeColorShade(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1183 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTSchemeColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorLumMod(CTPercentage paramCTPercentage) {
/* 1192 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "inv", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTInverseTransform> createCTSchemeColorInv(CTInverseTransform paramCTInverseTransform) {
/* 1201 */     return new JAXBElement<CTInverseTransform>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTSchemeColor.class, paramCTInverseTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorLumOff(CTPercentage paramCTPercentage) {
/* 1210 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "tint", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTSchemeColorTint(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1219 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTSchemeColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "green", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorGreen(CTPercentage paramCTPercentage) {
/* 1228 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "comp", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTComplementTransform> createCTSchemeColorComp(CTComplementTransform paramCTComplementTransform) {
/* 1237 */     return new JAXBElement<CTComplementTransform>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTSchemeColor.class, paramCTComplementTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueOff", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPercentage> createCTSchemeColorBlueOff(CTPercentage paramCTPercentage) {
/* 1246 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTSchemeColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueMod", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTSchemeColorHueMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1255 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTSchemeColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gray", scope = CTSchemeColor.class)
/*      */   public JAXBElement<CTGrayscaleTransform> createCTSchemeColorGray(CTGrayscaleTransform paramCTGrayscaleTransform) {
/* 1264 */     return new JAXBElement<CTGrayscaleTransform>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTSchemeColor.class, paramCTGrayscaleTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lum", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorLum(CTPercentage paramCTPercentage) {
/* 1273 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alpha", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTScRgbColorAlpha(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1282 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTScRgbColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gamma", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTGammaTransform> createCTScRgbColorGamma(CTGammaTransform paramCTGammaTransform) {
/* 1291 */     return new JAXBElement<CTGammaTransform>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTScRgbColor.class, paramCTGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "invGamma", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTInverseGammaTransform> createCTScRgbColorInvGamma(CTInverseGammaTransform paramCTInverseGammaTransform) {
/* 1300 */     return new JAXBElement<CTInverseGammaTransform>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTScRgbColor.class, paramCTInverseGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorRedOff(CTPercentage paramCTPercentage) {
/* 1309 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTScRgbColorAlphaMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1318 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTScRgbColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTFixedPercentage> createCTScRgbColorAlphaOff(CTFixedPercentage paramCTFixedPercentage) {
/* 1327 */     return new JAXBElement<CTFixedPercentage>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTScRgbColor.class, paramCTFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorGreenOff(CTPercentage paramCTPercentage) {
/* 1336 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hue", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedAngle> createCTScRgbColorHue(CTPositiveFixedAngle paramCTPositiveFixedAngle) {
/* 1345 */     return new JAXBElement<CTPositiveFixedAngle>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTScRgbColor.class, paramCTPositiveFixedAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorRedMod(CTPercentage paramCTPercentage) {
/* 1354 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorSatOff(CTPercentage paramCTPercentage) {
/* 1363 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorGreenMod(CTPercentage paramCTPercentage) {
/* 1372 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "sat", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorSat(CTPercentage paramCTPercentage) {
/* 1381 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blue", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorBlue(CTPercentage paramCTPercentage) {
/* 1390 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "red", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorRed(CTPercentage paramCTPercentage) {
/* 1399 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorSatMod(CTPercentage paramCTPercentage) {
/* 1408 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTAngle> createCTScRgbColorHueOff(CTAngle paramCTAngle) {
/* 1417 */     return new JAXBElement<CTAngle>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTScRgbColor.class, paramCTAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorBlueMod(CTPercentage paramCTPercentage) {
/* 1426 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "shade", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTScRgbColorShade(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1435 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTScRgbColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorLumMod(CTPercentage paramCTPercentage) {
/* 1444 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "inv", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTInverseTransform> createCTScRgbColorInv(CTInverseTransform paramCTInverseTransform) {
/* 1453 */     return new JAXBElement<CTInverseTransform>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTScRgbColor.class, paramCTInverseTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorLumOff(CTPercentage paramCTPercentage) {
/* 1462 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "tint", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTScRgbColorTint(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1471 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTScRgbColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "green", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorGreen(CTPercentage paramCTPercentage) {
/* 1480 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "comp", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTComplementTransform> createCTScRgbColorComp(CTComplementTransform paramCTComplementTransform) {
/* 1489 */     return new JAXBElement<CTComplementTransform>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTScRgbColor.class, paramCTComplementTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueOff", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPercentage> createCTScRgbColorBlueOff(CTPercentage paramCTPercentage) {
/* 1498 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTScRgbColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueMod", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTScRgbColorHueMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1507 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTScRgbColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gray", scope = CTScRgbColor.class)
/*      */   public JAXBElement<CTGrayscaleTransform> createCTScRgbColorGray(CTGrayscaleTransform paramCTGrayscaleTransform) {
/* 1516 */     return new JAXBElement<CTGrayscaleTransform>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTScRgbColor.class, paramCTGrayscaleTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alpha", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTHslColorAlpha(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1525 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTHslColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lum", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorLum(CTPercentage paramCTPercentage) {
/* 1534 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gamma", scope = CTHslColor.class)
/*      */   public JAXBElement<CTGammaTransform> createCTHslColorGamma(CTGammaTransform paramCTGammaTransform) {
/* 1543 */     return new JAXBElement<CTGammaTransform>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTHslColor.class, paramCTGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "invGamma", scope = CTHslColor.class)
/*      */   public JAXBElement<CTInverseGammaTransform> createCTHslColorInvGamma(CTInverseGammaTransform paramCTInverseGammaTransform) {
/* 1552 */     return new JAXBElement<CTInverseGammaTransform>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTHslColor.class, paramCTInverseGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTHslColorAlphaMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1561 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTHslColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorRedOff(CTPercentage paramCTPercentage) {
/* 1570 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTFixedPercentage> createCTHslColorAlphaOff(CTFixedPercentage paramCTFixedPercentage) {
/* 1579 */     return new JAXBElement<CTFixedPercentage>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTHslColor.class, paramCTFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorGreenOff(CTPercentage paramCTPercentage) {
/* 1588 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hue", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPositiveFixedAngle> createCTHslColorHue(CTPositiveFixedAngle paramCTPositiveFixedAngle) {
/* 1597 */     return new JAXBElement<CTPositiveFixedAngle>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTHslColor.class, paramCTPositiveFixedAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorRedMod(CTPercentage paramCTPercentage) {
/* 1606 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorSatOff(CTPercentage paramCTPercentage) {
/* 1615 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorGreenMod(CTPercentage paramCTPercentage) {
/* 1624 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blue", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorBlue(CTPercentage paramCTPercentage) {
/* 1633 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "sat", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorSat(CTPercentage paramCTPercentage) {
/* 1642 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "red", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorRed(CTPercentage paramCTPercentage) {
/* 1651 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorSatMod(CTPercentage paramCTPercentage) {
/* 1660 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorBlueMod(CTPercentage paramCTPercentage) {
/* 1669 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTAngle> createCTHslColorHueOff(CTAngle paramCTAngle) {
/* 1678 */     return new JAXBElement<CTAngle>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTHslColor.class, paramCTAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "shade", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTHslColorShade(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1687 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTHslColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorLumMod(CTPercentage paramCTPercentage) {
/* 1696 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "inv", scope = CTHslColor.class)
/*      */   public JAXBElement<CTInverseTransform> createCTHslColorInv(CTInverseTransform paramCTInverseTransform) {
/* 1705 */     return new JAXBElement<CTInverseTransform>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTHslColor.class, paramCTInverseTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorLumOff(CTPercentage paramCTPercentage) {
/* 1714 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "tint", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTHslColorTint(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1723 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTHslColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "green", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorGreen(CTPercentage paramCTPercentage) {
/* 1732 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "comp", scope = CTHslColor.class)
/*      */   public JAXBElement<CTComplementTransform> createCTHslColorComp(CTComplementTransform paramCTComplementTransform) {
/* 1741 */     return new JAXBElement<CTComplementTransform>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTHslColor.class, paramCTComplementTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueOff", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPercentage> createCTHslColorBlueOff(CTPercentage paramCTPercentage) {
/* 1750 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTHslColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueMod", scope = CTHslColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTHslColorHueMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1759 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTHslColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gray", scope = CTHslColor.class)
/*      */   public JAXBElement<CTGrayscaleTransform> createCTHslColorGray(CTGrayscaleTransform paramCTGrayscaleTransform) {
/* 1768 */     return new JAXBElement<CTGrayscaleTransform>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTHslColor.class, paramCTGrayscaleTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lum", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorLum(CTPercentage paramCTPercentage) {
/* 1777 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alpha", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTPresetColorAlpha(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1786 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTPresetColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gamma", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTGammaTransform> createCTPresetColorGamma(CTGammaTransform paramCTGammaTransform) {
/* 1795 */     return new JAXBElement<CTGammaTransform>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTPresetColor.class, paramCTGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "invGamma", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTInverseGammaTransform> createCTPresetColorInvGamma(CTInverseGammaTransform paramCTInverseGammaTransform) {
/* 1804 */     return new JAXBElement<CTInverseGammaTransform>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTPresetColor.class, paramCTInverseGammaTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorRedOff(CTPercentage paramCTPercentage) {
/* 1813 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTPresetColorAlphaMod(CTPositivePercentage paramCTPositivePercentage) {
/* 1822 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTPresetColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "alphaOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTFixedPercentage> createCTPresetColorAlphaOff(CTFixedPercentage paramCTFixedPercentage) {
/* 1831 */     return new JAXBElement<CTFixedPercentage>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTPresetColor.class, paramCTFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorGreenOff(CTPercentage paramCTPercentage) {
/* 1840 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hue", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPositiveFixedAngle> createCTPresetColorHue(CTPositiveFixedAngle paramCTPositiveFixedAngle) {
/* 1849 */     return new JAXBElement<CTPositiveFixedAngle>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTPresetColor.class, paramCTPositiveFixedAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "redMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorRedMod(CTPercentage paramCTPercentage) {
/* 1858 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorSatOff(CTPercentage paramCTPercentage) {
/* 1867 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "greenMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorGreenMod(CTPercentage paramCTPercentage) {
/* 1876 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blue", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorBlue(CTPercentage paramCTPercentage) {
/* 1885 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "sat", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorSat(CTPercentage paramCTPercentage) {
/* 1894 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "red", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorRed(CTPercentage paramCTPercentage) {
/* 1903 */     return new JAXBElement<CTPercentage>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "satMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorSatMod(CTPercentage paramCTPercentage) {
/* 1912 */     return new JAXBElement<CTPercentage>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorBlueMod(CTPercentage paramCTPercentage) {
/* 1921 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTAngle> createCTPresetColorHueOff(CTAngle paramCTAngle) {
/* 1930 */     return new JAXBElement<CTAngle>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTPresetColor.class, paramCTAngle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "shade", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTPresetColorShade(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1939 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTPresetColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorLumMod(CTPercentage paramCTPercentage) {
/* 1948 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "inv", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTInverseTransform> createCTPresetColorInv(CTInverseTransform paramCTInverseTransform) {
/* 1957 */     return new JAXBElement<CTInverseTransform>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTPresetColor.class, paramCTInverseTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "lumOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorLumOff(CTPercentage paramCTPercentage) {
/* 1966 */     return new JAXBElement<CTPercentage>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "tint", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPositiveFixedPercentage> createCTPresetColorTint(CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
/* 1975 */     return new JAXBElement<CTPositiveFixedPercentage>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTPresetColor.class, paramCTPositiveFixedPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "green", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorGreen(CTPercentage paramCTPercentage) {
/* 1984 */     return new JAXBElement<CTPercentage>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "comp", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTComplementTransform> createCTPresetColorComp(CTComplementTransform paramCTComplementTransform) {
/* 1993 */     return new JAXBElement<CTComplementTransform>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTPresetColor.class, paramCTComplementTransform);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "blueOff", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPercentage> createCTPresetColorBlueOff(CTPercentage paramCTPercentage) {
/* 2002 */     return new JAXBElement<CTPercentage>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTPresetColor.class, paramCTPercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "hueMod", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTPositivePercentage> createCTPresetColorHueMod(CTPositivePercentage paramCTPositivePercentage) {
/* 2011 */     return new JAXBElement<CTPositivePercentage>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTPresetColor.class, paramCTPositivePercentage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", name = "gray", scope = CTPresetColor.class)
/*      */   public JAXBElement<CTGrayscaleTransform> createCTPresetColorGray(CTGrayscaleTransform paramCTGrayscaleTransform) {
/* 2020 */     return new JAXBElement<CTGrayscaleTransform>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTPresetColor.class, paramCTGrayscaleTransform);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */