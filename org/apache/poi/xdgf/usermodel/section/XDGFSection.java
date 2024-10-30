/*    */ package org.apache.poi.xdgf.usermodel.section;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.SectionType;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.poi.POIXMLException;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFCell;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFSheet;
/*    */ import org.apache.poi.xdgf.util.ObjectFactory;
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
/*    */ public abstract class XDGFSection
/*    */ {
/* 37 */   static final ObjectFactory<XDGFSection, SectionType> _sectionTypes = new ObjectFactory(); protected SectionType _section; static {
/*    */     try {
/* 39 */       _sectionTypes.put("LineGradient", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 40 */       _sectionTypes.put("FillGradient", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 41 */       _sectionTypes.put("Character", CharacterSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 42 */       _sectionTypes.put("Paragraph", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 43 */       _sectionTypes.put("Tabs", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 44 */       _sectionTypes.put("Scratch", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 45 */       _sectionTypes.put("Connection", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 46 */       _sectionTypes.put("ConnectionABCD", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 47 */       _sectionTypes.put("Field", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 48 */       _sectionTypes.put("Control", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 49 */       _sectionTypes.put("Geometry", GeometrySection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 50 */       _sectionTypes.put("Actions", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 51 */       _sectionTypes.put("Layer", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 52 */       _sectionTypes.put("User", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 53 */       _sectionTypes.put("Property", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 54 */       _sectionTypes.put("Hyperlink", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 55 */       _sectionTypes.put("Reviewer", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 56 */       _sectionTypes.put("Annotation", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 57 */       _sectionTypes.put("ActionTag", GenericSection.class, new Class[] { SectionType.class, XDGFSheet.class });
/* 58 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 59 */       throw new POIXMLException("Internal error");
/* 60 */     } catch (SecurityException securityException) {
/* 61 */       throw new POIXMLException("Internal error");
/*    */     } 
/*    */   }
/*    */   protected XDGFSheet _containingSheet;
/*    */   
/*    */   public static XDGFSection load(SectionType paramSectionType, XDGFSheet paramXDGFSheet) {
/* 67 */     return (XDGFSection)_sectionTypes.load(paramSectionType.getN(), new Object[] { paramSectionType, paramXDGFSheet });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 74 */   protected Map<String, XDGFCell> _cells = new HashMap<String, XDGFCell>();
/*    */ 
/*    */   
/*    */   public XDGFSection(SectionType paramSectionType, XDGFSheet paramXDGFSheet) {
/* 78 */     this._section = paramSectionType;
/* 79 */     this._containingSheet = paramXDGFSheet;
/*    */ 
/*    */ 
/*    */     
/* 83 */     for (CellType cellType : paramSectionType.getCellArray()) {
/* 84 */       this._cells.put(cellType.getN(), new XDGFCell(cellType));
/*    */     }
/*    */   }
/*    */   
/*    */   @Internal
/*    */   public SectionType getXmlObject() {
/* 90 */     return this._section;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 95 */     return "<Section type=" + this._section.getN() + " from " + this._containingSheet + ">";
/*    */   }
/*    */   
/*    */   public abstract void setupMaster(XDGFSection paramXDGFSection);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\XDGFSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */