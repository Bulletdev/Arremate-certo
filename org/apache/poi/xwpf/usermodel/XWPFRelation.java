/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLRelation;
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
/*     */ public final class XWPFRelation
/*     */   extends POIXMLRelation
/*     */ {
/*  34 */   private static final Map<String, XWPFRelation> _table = new HashMap<String, XWPFRelation>();
/*     */   
/*  36 */   public static final XWPFRelation DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public static final XWPFRelation TEMPLATE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static final XWPFRelation MACRO_DOCUMENT = new XWPFRelation("application/vnd.ms-word.document.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   public static final XWPFRelation MACRO_TEMPLATE_DOCUMENT = new XWPFRelation("application/vnd.ms-word.template.macroEnabledTemplate.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final XWPFRelation GLOSSARY_DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/glossaryDocument", "/word/glossary/document.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static final XWPFRelation NUMBERING = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/numbering", "/word/numbering.xml", (Class)XWPFNumbering.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final XWPFRelation FONT_TABLE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable", "/word/fontTable.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public static final XWPFRelation SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings", "/word/settings.xml", (Class)XWPFSettings.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final XWPFRelation STYLES = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles", "/word/styles.xml", (Class)XWPFStyles.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final XWPFRelation WEB_SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings", "/word/webSettings.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public static final XWPFRelation HEADER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.header+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/header", "/word/header#.xml", (Class)XWPFHeader.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public static final XWPFRelation FOOTER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer", "/word/footer#.xml", (Class)XWPFFooter.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public static final XWPFRelation THEME = new XWPFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/word/theme/theme#.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public static final XWPFRelation HYPERLINK = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   public static final XWPFRelation COMMENT = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public static final XWPFRelation FOOTNOTE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footnotes", "/word/footnotes.xml", (Class)XWPFFootnotes.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public static final XWPFRelation ENDNOTE = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/endnotes", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public static final XWPFRelation IMAGE_EMF = new XWPFRelation("image/x-emf", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.emf", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public static final XWPFRelation IMAGE_WMF = new XWPFRelation("image/x-wmf", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.wmf", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   public static final XWPFRelation IMAGE_PICT = new XWPFRelation("image/pict", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.pict", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   public static final XWPFRelation IMAGE_JPEG = new XWPFRelation("image/jpeg", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.jpeg", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public static final XWPFRelation IMAGE_PNG = new XWPFRelation("image/png", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.png", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   public static final XWPFRelation IMAGE_DIB = new XWPFRelation("image/dib", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.dib", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 177 */   public static final XWPFRelation IMAGE_GIF = new XWPFRelation("image/gif", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.gif", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   public static final XWPFRelation IMAGE_TIFF = new XWPFRelation("image/tiff", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.tiff", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   public static final XWPFRelation IMAGE_EPS = new XWPFRelation("image/x-eps", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.eps", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 195 */   public static final XWPFRelation IMAGE_BMP = new XWPFRelation("image/x-ms-bmp", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.bmp", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 201 */   public static final XWPFRelation IMAGE_WPG = new XWPFRelation("image/x-wpg", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/word/media/image#.wpg", (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   public static final XWPFRelation IMAGES = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, (Class)XWPFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XWPFRelation(String paramString1, String paramString2, String paramString3, Class<? extends POIXMLDocumentPart> paramClass) {
/* 215 */     super(paramString1, paramString2, paramString3, paramClass);
/* 216 */     _table.put(paramString2, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XWPFRelation getInstance(String paramString) {
/* 227 */     return _table.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */