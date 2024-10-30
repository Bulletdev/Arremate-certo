/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
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
/*     */ public class XSLFRelation
/*     */   extends POIXMLRelation
/*     */ {
/*  33 */   private static final Map<String, XSLFRelation> _table = new HashMap<String, XSLFRelation>();
/*     */   
/*  35 */   public static final XSLFRelation MAIN = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   public static final XSLFRelation MACRO = new XSLFRelation("application/vnd.ms-powerpoint.slideshow.macroEnabled.main+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   public static final XSLFRelation MACRO_TEMPLATE = new XSLFRelation("application/vnd.ms-powerpoint.template.macroEnabled.main+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   public static final XSLFRelation PRESENTATIONML = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideshow.main+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final XSLFRelation PRESENTATIONML_TEMPLATE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.template.main+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final XSLFRelation PRESENTATION_MACRO = new XSLFRelation("application/vnd.ms-powerpoint.presentation.macroEnabled.main+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final XSLFRelation THEME_MANAGER = new XSLFRelation("application/vnd.openxmlformats-officedocument.themeManager+xml", null, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final XSLFRelation NOTES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesSlide", "/ppt/notesSlides/notesSlide#.xml", (Class)XSLFNotes.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public static final XSLFRelation SLIDE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slide", "/ppt/slides/slide#.xml", (Class)XSLFSlide.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final XSLFRelation SLIDE_LAYOUT = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout", "/ppt/slideLayouts/slideLayout#.xml", (Class)XSLFSlideLayout.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public static final XSLFRelation SLIDE_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster", "/ppt/slideMasters/slideMaster#.xml", (Class)XSLFSlideMaster.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public static final XSLFRelation NOTES_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesMaster", "/ppt/notesMasters/notesMaster#.xml", (Class)XSLFNotesMaster.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public static final XSLFRelation COMMENTS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/ppt/comments/comment#.xml", (Class)XSLFComments.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public static final XSLFRelation COMMENT_AUTHORS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.commentAuthors+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/commentAuthors", "/ppt/commentAuthors.xml", (Class)XSLFCommentAuthors.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public static final XSLFRelation HYPERLINK = new XSLFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public static final XSLFRelation THEME = new XSLFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/ppt/theme/theme#.xml", (Class)XSLFTheme.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public static final XSLFRelation VML_DRAWING = new XSLFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/ppt/drawings/vmlDrawing#.vml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   public static final XSLFRelation CHART = new XSLFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/ppt/charts/chart#.xml", (Class)XSLFChart.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public static final XSLFRelation IMAGE_EMF = new XSLFRelation(PictureData.PictureType.EMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.emf", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   public static final XSLFRelation IMAGE_WMF = new XSLFRelation(PictureData.PictureType.WMF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.wmf", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   public static final XSLFRelation IMAGE_PICT = new XSLFRelation(PictureData.PictureType.PICT.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.pict", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public static final XSLFRelation IMAGE_JPEG = new XSLFRelation(PictureData.PictureType.JPEG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.jpeg", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   public static final XSLFRelation IMAGE_PNG = new XSLFRelation(PictureData.PictureType.PNG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.png", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 177 */   public static final XSLFRelation IMAGE_DIB = new XSLFRelation(PictureData.PictureType.DIB.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.dib", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   public static final XSLFRelation IMAGE_GIF = new XSLFRelation(PictureData.PictureType.GIF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.gif", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   public static final XSLFRelation IMAGE_TIFF = new XSLFRelation(PictureData.PictureType.TIFF.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.tiff", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 195 */   public static final XSLFRelation IMAGE_EPS = new XSLFRelation(PictureData.PictureType.EPS.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.eps", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 201 */   public static final XSLFRelation IMAGE_BMP = new XSLFRelation(PictureData.PictureType.BMP.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.bmp", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   public static final XSLFRelation IMAGE_WPG = new XSLFRelation(PictureData.PictureType.WPG.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.wpg", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 213 */   public static final XSLFRelation IMAGE_WDP = new XSLFRelation(PictureData.PictureType.WDP.contentType, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/ppt/media/image#.wdp", (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 220 */   public static final XSLFRelation IMAGES = new XSLFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, (Class)XSLFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 227 */   public static final XSLFRelation TABLE_STYLES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableStyles", "/ppt/tableStyles.xml", (Class)XSLFTableStyles.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XSLFRelation(String paramString1, String paramString2, String paramString3, Class<? extends POIXMLDocumentPart> paramClass) {
/* 235 */     super(paramString1, paramString2, paramString3, paramClass);
/* 236 */     _table.put(paramString2, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSLFRelation getInstance(String paramString) {
/* 247 */     return _table.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */