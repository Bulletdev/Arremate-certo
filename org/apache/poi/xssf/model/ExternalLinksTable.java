/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.ss.usermodel.Name;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;
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
/*     */ public class ExternalLinksTable
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTExternalLink link;
/*     */   
/*     */   public ExternalLinksTable() {
/*  48 */     this.link = CTExternalLink.Factory.newInstance();
/*  49 */     this.link.addNewExternalBook();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExternalLinksTable(PackagePart paramPackagePart) throws IOException {
/*  56 */     super(paramPackagePart);
/*  57 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ExternalLinksTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  65 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  70 */       ExternalLinkDocument externalLinkDocument = ExternalLinkDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  71 */       this.link = externalLinkDocument.getExternalLink();
/*  72 */     } catch (XmlException xmlException) {
/*  73 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*  77 */     ExternalLinkDocument externalLinkDocument = ExternalLinkDocument.Factory.newInstance();
/*  78 */     externalLinkDocument.setExternalLink(this.link);
/*  79 */     externalLinkDocument.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/*  84 */     PackagePart packagePart = getPackagePart();
/*  85 */     OutputStream outputStream = packagePart.getOutputStream();
/*  86 */     writeTo(outputStream);
/*  87 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTExternalLink getCTExternalLink() {
/*  95 */     return this.link;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLinkedFileName() {
/* 103 */     String str = this.link.getExternalBook().getId();
/* 104 */     PackageRelationship packageRelationship = getPackagePart().getRelationship(str);
/* 105 */     if (packageRelationship != null && packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
/* 106 */       return packageRelationship.getTargetURI().toString();
/*     */     }
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinkedFileName(String paramString) {
/* 115 */     String str = this.link.getExternalBook().getId();
/*     */     
/* 117 */     if (str != null && !str.isEmpty())
/*     */     {
/*     */ 
/*     */       
/* 121 */       getPackagePart().removeRelationship(str);
/*     */     }
/*     */ 
/*     */     
/* 125 */     PackageRelationship packageRelationship = getPackagePart().addExternalRelationship(paramString, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLinkPath");
/*     */     
/* 127 */     this.link.getExternalBook().setId(packageRelationship.getId());
/*     */   }
/*     */   
/*     */   public List<String> getSheetNames() {
/* 131 */     CTExternalSheetName[] arrayOfCTExternalSheetName = this.link.getExternalBook().getSheetNames().getSheetNameArray();
/*     */     
/* 133 */     ArrayList<String> arrayList = new ArrayList(arrayOfCTExternalSheetName.length);
/* 134 */     for (CTExternalSheetName cTExternalSheetName : arrayOfCTExternalSheetName) {
/* 135 */       arrayList.add(cTExternalSheetName.getVal());
/*     */     }
/* 137 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<Name> getDefinedNames() {
/* 141 */     CTExternalDefinedName[] arrayOfCTExternalDefinedName = this.link.getExternalBook().getDefinedNames().getDefinedNameArray();
/*     */     
/* 143 */     ArrayList<ExternalName> arrayList = new ArrayList(arrayOfCTExternalDefinedName.length);
/* 144 */     for (CTExternalDefinedName cTExternalDefinedName : arrayOfCTExternalDefinedName) {
/* 145 */       arrayList.add(new ExternalName(cTExternalDefinedName));
/*     */     }
/* 147 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected class ExternalName
/*     */     implements Name
/*     */   {
/*     */     private CTExternalDefinedName name;
/*     */     
/*     */     protected ExternalName(CTExternalDefinedName param1CTExternalDefinedName) {
/* 157 */       this.name = param1CTExternalDefinedName;
/*     */     }
/*     */     
/*     */     public String getNameName() {
/* 161 */       return this.name.getName();
/*     */     }
/*     */     public void setNameName(String param1String) {
/* 164 */       this.name.setName(param1String);
/*     */     }
/*     */     
/*     */     public String getSheetName() {
/* 168 */       int i = getSheetIndex();
/* 169 */       if (i >= 0) {
/* 170 */         return ExternalLinksTable.this.getSheetNames().get(i);
/*     */       }
/* 172 */       return null;
/*     */     }
/*     */     
/*     */     public int getSheetIndex() {
/* 176 */       if (this.name.isSetSheetId()) {
/* 177 */         return (int)this.name.getSheetId();
/*     */       }
/* 179 */       return -1;
/*     */     }
/*     */     public void setSheetIndex(int param1Int) {
/* 182 */       this.name.setSheetId(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getRefersToFormula() {
/* 187 */       return this.name.getRefersTo().substring(1);
/*     */     }
/*     */     
/*     */     public void setRefersToFormula(String param1String) {
/* 191 */       this.name.setRefersTo('=' + param1String);
/*     */     }
/*     */     
/*     */     public boolean isFunctionName() {
/* 195 */       return false;
/*     */     }
/*     */     public boolean isDeleted() {
/* 198 */       return false;
/*     */     }
/*     */     
/*     */     public String getComment() {
/* 202 */       return null;
/*     */     }
/*     */     public void setComment(String param1String) {
/* 205 */       throw new IllegalStateException("Not Supported");
/*     */     }
/*     */     public void setFunction(boolean param1Boolean) {
/* 208 */       throw new IllegalStateException("Not Supported");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\ExternalLinksTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */