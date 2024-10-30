/*     */ package org.apache.poi.xssf.eventusermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.SAXHelper;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRelation;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.XMLReader;
/*     */ import org.xml.sax.helpers.DefaultHandler;
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
/*     */ public class ReadOnlySharedStringsTable
/*     */   extends DefaultHandler
/*     */ {
/*     */   private int count;
/*     */   private int uniqueCount;
/*     */   private List<String> strings;
/*     */   private StringBuffer characters;
/*     */   private boolean tIsOpen;
/*     */   
/*     */   public ReadOnlySharedStringsTable(OPCPackage paramOPCPackage) throws IOException, SAXException {
/* 107 */     ArrayList<PackagePart> arrayList = paramOPCPackage.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
/*     */ 
/*     */ 
/*     */     
/* 111 */     if (arrayList.size() > 0) {
/* 112 */       PackagePart packagePart = arrayList.get(0);
/* 113 */       readFrom(packagePart.getInputStream());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReadOnlySharedStringsTable(PackagePart paramPackagePart) throws IOException, SAXException {
/* 123 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ReadOnlySharedStringsTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, SAXException {
/* 132 */     this(paramPackagePart);
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
/*     */   public void readFrom(InputStream paramInputStream) throws IOException, SAXException {
/* 145 */     PushbackInputStream pushbackInputStream = new PushbackInputStream(paramInputStream, 1);
/* 146 */     int i = pushbackInputStream.read();
/* 147 */     if (i > -1) {
/* 148 */       pushbackInputStream.unread(i);
/* 149 */       InputSource inputSource = new InputSource(pushbackInputStream);
/*     */       try {
/* 151 */         XMLReader xMLReader = SAXHelper.newXMLReader();
/* 152 */         xMLReader.setContentHandler(this);
/* 153 */         xMLReader.parse(inputSource);
/* 154 */       } catch (ParserConfigurationException parserConfigurationException) {
/* 155 */         throw new RuntimeException("SAX parser appears to be broken - " + parserConfigurationException.getMessage());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount() {
/* 167 */     return this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUniqueCount() {
/* 178 */     return this.uniqueCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntryAt(int paramInt) {
/* 189 */     return this.strings.get(paramInt);
/*     */   }
/*     */   
/*     */   public List<String> getItems() {
/* 193 */     return this.strings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) throws SAXException {
/* 203 */     if (paramString1 != null && !paramString1.equals("http://schemas.openxmlformats.org/spreadsheetml/2006/main")) {
/*     */       return;
/*     */     }
/*     */     
/* 207 */     if ("sst".equals(paramString2)) {
/* 208 */       String str1 = paramAttributes.getValue("count");
/* 209 */       if (str1 != null) this.count = Integer.parseInt(str1); 
/* 210 */       String str2 = paramAttributes.getValue("uniqueCount");
/* 211 */       if (str2 != null) this.uniqueCount = Integer.parseInt(str2);
/*     */       
/* 213 */       this.strings = new ArrayList<String>(this.uniqueCount);
/*     */       
/* 215 */       this.characters = new StringBuffer();
/* 216 */     } else if ("si".equals(paramString2)) {
/* 217 */       this.characters.setLength(0);
/* 218 */     } else if ("t".equals(paramString2)) {
/* 219 */       this.tIsOpen = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void endElement(String paramString1, String paramString2, String paramString3) throws SAXException {
/* 225 */     if (paramString1 != null && !paramString1.equals("http://schemas.openxmlformats.org/spreadsheetml/2006/main")) {
/*     */       return;
/*     */     }
/*     */     
/* 229 */     if ("si".equals(paramString2)) {
/* 230 */       this.strings.add(this.characters.toString());
/* 231 */     } else if ("t".equals(paramString2)) {
/* 232 */       this.tIsOpen = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void characters(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws SAXException {
/* 241 */     if (this.tIsOpen)
/* 242 */       this.characters.append(paramArrayOfchar, paramInt1, paramInt2); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\eventusermodel\ReadOnlySharedStringsTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */