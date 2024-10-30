/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.LinkedList;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public class MutablePropertySet
/*     */   extends PropertySet
/*     */ {
/*     */   public MutablePropertySet() {
/*  51 */     this.byteOrder = LittleEndian.getUShort(BYTE_ORDER_ASSERTION);
/*     */ 
/*     */     
/*  54 */     this.format = LittleEndian.getUShort(FORMAT_ASSERTION);
/*     */ 
/*     */ 
/*     */     
/*  58 */     this.osVersion = 133636;
/*     */ 
/*     */     
/*  61 */     this.classID = new ClassID();
/*     */ 
/*     */ 
/*     */     
/*  65 */     this.sections = new LinkedList<Section>();
/*  66 */     this.sections.add(new MutableSection());
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
/*     */   public MutablePropertySet(PropertySet paramPropertySet) {
/*  81 */     this.byteOrder = paramPropertySet.getByteOrder();
/*  82 */     this.format = paramPropertySet.getFormat();
/*  83 */     this.osVersion = paramPropertySet.getOSVersion();
/*  84 */     setClassID(paramPropertySet.getClassID());
/*  85 */     clearSections();
/*  86 */     if (this.sections == null)
/*  87 */       this.sections = new LinkedList<Section>(); 
/*  88 */     for (Section section : paramPropertySet.getSections()) {
/*     */       
/*  90 */       MutableSection mutableSection = new MutableSection(section);
/*  91 */       addSection(mutableSection);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   private static final int OFFSET_HEADER = BYTE_ORDER_ASSERTION.length + FORMAT_ASSERTION.length + 4 + 16 + 4;
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
/*     */   public void setByteOrder(int paramInt) {
/* 116 */     this.byteOrder = paramInt;
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
/*     */   public void setFormat(int paramInt) {
/* 128 */     this.format = paramInt;
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
/*     */   public void setOSVersion(int paramInt) {
/* 140 */     this.osVersion = paramInt;
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
/*     */   public void setClassID(ClassID paramClassID) {
/* 155 */     this.classID = paramClassID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearSections() {
/* 165 */     this.sections = null;
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
/*     */   public void addSection(Section paramSection) {
/* 179 */     if (this.sections == null)
/* 180 */       this.sections = new LinkedList<Section>(); 
/* 181 */     this.sections.add(paramSection);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(OutputStream paramOutputStream) throws WritingNotSupportedException, IOException {
/* 199 */     int i = this.sections.size();
/*     */ 
/*     */     
/* 202 */     TypeWriter.writeToStream(paramOutputStream, (short)getByteOrder());
/* 203 */     TypeWriter.writeToStream(paramOutputStream, (short)getFormat());
/* 204 */     TypeWriter.writeToStream(paramOutputStream, getOSVersion());
/* 205 */     TypeWriter.writeToStream(paramOutputStream, getClassID());
/* 206 */     TypeWriter.writeToStream(paramOutputStream, i);
/* 207 */     int j = OFFSET_HEADER;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     j += i * 20;
/* 213 */     int k = j;
/* 214 */     for (Section section : this.sections) {
/*     */       
/* 216 */       MutableSection mutableSection = (MutableSection)section;
/* 217 */       ClassID classID = mutableSection.getFormatID();
/* 218 */       if (classID == null)
/* 219 */         throw new NoFormatIDException(); 
/* 220 */       TypeWriter.writeToStream(paramOutputStream, mutableSection.getFormatID());
/* 221 */       TypeWriter.writeUIntToStream(paramOutputStream, j);
/*     */       
/*     */       try {
/* 224 */         j += mutableSection.getSize();
/*     */       }
/* 226 */       catch (HPSFRuntimeException hPSFRuntimeException) {
/*     */         
/* 228 */         Throwable throwable = hPSFRuntimeException.getReason();
/* 229 */         if (throwable instanceof java.io.UnsupportedEncodingException) {
/* 230 */           throw new IllegalPropertySetDataException(throwable);
/*     */         }
/* 232 */         throw hPSFRuntimeException;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 237 */     j = k;
/* 238 */     for (Section section : this.sections) {
/*     */       
/* 240 */       MutableSection mutableSection = (MutableSection)section;
/* 241 */       j += mutableSection.write(paramOutputStream);
/*     */     } 
/*     */ 
/*     */     
/* 245 */     paramOutputStream.close();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream toInputStream() throws IOException, WritingNotSupportedException {
/* 267 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 269 */       write(byteArrayOutputStream);
/*     */     } finally {
/* 271 */       byteArrayOutputStream.close();
/*     */     } 
/* 273 */     byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 274 */     return new ByteArrayInputStream(arrayOfByte);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(DirectoryEntry paramDirectoryEntry, String paramString) throws WritingNotSupportedException, IOException {
/*     */     try {
/* 293 */       Entry entry = paramDirectoryEntry.getEntry(paramString);
/* 294 */       entry.delete();
/*     */     }
/* 296 */     catch (FileNotFoundException fileNotFoundException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     paramDirectoryEntry.createDocument(paramString, toInputStream());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\MutablePropertySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */