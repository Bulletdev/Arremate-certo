/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.poi.POIXMLRelation;
/*    */ import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
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
/*    */ public class XDGFRelation
/*    */   extends POIXMLRelation
/*    */ {
/* 32 */   private static final Map<String, XDGFRelation> _table = new HashMap<String, XDGFRelation>();
/*    */   
/* 34 */   public static final XDGFRelation DOCUMENT = new XDGFRelation("application/vnd.ms-visio.drawing.main+xml", "http://schemas.microsoft.com/visio/2010/relationships/document", "/visio/document.xml", null);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   public static final XDGFRelation MASTERS = new XDGFRelation("application/vnd.ms-visio.masters+xml", "http://schemas.microsoft.com/visio/2010/relationships/masters", "/visio/masters/masters.xml", (Class)XDGFMasters.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   public static final XDGFRelation MASTER = new XDGFRelation("application/vnd.ms-visio.master+xml", "http://schemas.microsoft.com/visio/2010/relationships/master", "/visio/masters/master#.xml", (Class)XDGFMasterContents.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   public static final XDGFRelation IMAGES = new XDGFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, null);
/*    */ 
/*    */ 
/*    */   
/* 53 */   public static final XDGFRelation PAGES = new XDGFRelation("application/vnd.ms-visio.pages+xml", "http://schemas.microsoft.com/visio/2010/relationships/pages", "/visio/pages/pages.xml", (Class)XDGFPages.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 58 */   public static final XDGFRelation PAGE = new XDGFRelation("application/vnd.ms-visio.page+xml", "http://schemas.microsoft.com/visio/2010/relationships/page", "/visio/pages/page#.xml", (Class)XDGFPageContents.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 63 */   public static final XDGFRelation WINDOW = new XDGFRelation("application/vnd.ms-visio.windows+xml", "http://schemas.microsoft.com/visio/2010/relationships/windows", "/visio/windows.xml", null);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private XDGFRelation(String paramString1, String paramString2, String paramString3, Class<? extends XDGFXMLDocumentPart> paramClass) {
/* 69 */     super(paramString1, paramString2, paramString3, paramClass);
/* 70 */     _table.put(paramString2, this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static XDGFRelation getInstance(String paramString) {
/* 82 */     return _table.get(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */