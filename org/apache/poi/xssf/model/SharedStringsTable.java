/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;
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
/*     */ public class SharedStringsTable
/*     */   extends POIXMLDocumentPart
/*     */ {
/*  67 */   private final List<CTRst> strings = new ArrayList<CTRst>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   private final Map<String, Integer> stmap = new HashMap<String, Integer>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int count;
/*     */ 
/*     */ 
/*     */   
/*     */   private int uniqueCount;
/*     */ 
/*     */ 
/*     */   
/*     */   private SstDocument _sstDoc;
/*     */ 
/*     */ 
/*     */   
/*  89 */   private static final XmlOptions options = new XmlOptions();
/*     */   static {
/*  91 */     options.put("SAVE_INNER");
/*  92 */     options.put("SAVE_AGGRESSIVE_NAMESPACES");
/*  93 */     options.put("SAVE_USE_DEFAULT_NAMESPACE");
/*  94 */     options.setSaveImplicitNamespaces(Collections.singletonMap("", "http://schemas.openxmlformats.org/spreadsheetml/2006/main"));
/*     */   }
/*     */ 
/*     */   
/*     */   public SharedStringsTable() {
/*  99 */     this._sstDoc = SstDocument.Factory.newInstance();
/* 100 */     this._sstDoc.addNewSst();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedStringsTable(PackagePart paramPackagePart) throws IOException {
/* 107 */     super(paramPackagePart);
/* 108 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedStringsTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/* 115 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/* 126 */       byte b = 0;
/* 127 */       this._sstDoc = SstDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 128 */       CTSst cTSst = this._sstDoc.getSst();
/* 129 */       this.count = (int)cTSst.getCount();
/* 130 */       this.uniqueCount = (int)cTSst.getUniqueCount();
/* 131 */       for (CTRst cTRst : cTSst.getSiArray()) {
/* 132 */         this.stmap.put(getKey(cTRst), Integer.valueOf(b));
/* 133 */         this.strings.add(cTRst);
/* 134 */         b++;
/*     */       } 
/* 136 */     } catch (XmlException xmlException) {
/* 137 */       throw new IOException("unable to parse shared strings table", xmlException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getKey(CTRst paramCTRst) {
/* 142 */     return paramCTRst.xmlText(options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTRst getEntryAt(int paramInt) {
/* 152 */     return this.strings.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount() {
/* 162 */     return this.count;
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
/* 173 */     return this.uniqueCount;
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
/*     */ 
/*     */   
/*     */   public int addEntry(CTRst paramCTRst) {
/* 188 */     String str = getKey(paramCTRst);
/* 189 */     this.count++;
/* 190 */     if (this.stmap.containsKey(str)) {
/* 191 */       return ((Integer)this.stmap.get(str)).intValue();
/*     */     }
/*     */     
/* 194 */     this.uniqueCount++;
/*     */     
/* 196 */     CTRst cTRst = this._sstDoc.getSst().addNewSi();
/* 197 */     cTRst.set((XmlObject)paramCTRst);
/* 198 */     int i = this.strings.size();
/* 199 */     this.stmap.put(str, Integer.valueOf(i));
/* 200 */     this.strings.add(cTRst);
/* 201 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CTRst> getItems() {
/* 209 */     return Collections.unmodifiableList(this.strings);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 219 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */     
/* 222 */     xmlOptions.setSaveCDataLengthThreshold(1000000);
/* 223 */     xmlOptions.setSaveCDataEntityCountThreshold(-1);
/*     */ 
/*     */     
/* 226 */     CTSst cTSst = this._sstDoc.getSst();
/* 227 */     cTSst.setCount(this.count);
/* 228 */     cTSst.setUniqueCount(this.uniqueCount);
/*     */     
/* 230 */     this._sstDoc.save(paramOutputStream, xmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 235 */     PackagePart packagePart = getPackagePart();
/* 236 */     OutputStream outputStream = packagePart.getOutputStream();
/* 237 */     writeTo(outputStream);
/* 238 */     outputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\SharedStringsTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */