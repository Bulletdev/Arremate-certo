/*     */ package org.apache.poi.hssf.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.hssf.record.RecordFactory;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
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
/*     */ public class RecordLister
/*     */ {
/*     */   String file;
/*     */   
/*     */   public void run() throws IOException {
/*  53 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(this.file), true);
/*     */     try {
/*  55 */       InputStream inputStream = BiffViewer.getPOIFSInputStream(nPOIFSFileSystem);
/*     */       try {
/*  57 */         RecordInputStream recordInputStream = new RecordInputStream(inputStream);
/*     */         
/*  59 */         while (recordInputStream.hasNextRecord()) {
/*  60 */           int i = recordInputStream.getNextSid();
/*  61 */           recordInputStream.nextRecord();
/*     */           
/*  63 */           int j = recordInputStream.available();
/*  64 */           Class clazz = RecordFactory.getRecordClass(i);
/*     */           
/*  66 */           System.out.print(formatSID(i) + " - " + formatSize(j) + " bytes");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  72 */           if (clazz != null) {
/*  73 */             System.out.print("  \t");
/*  74 */             System.out.print(clazz.getName().replace("org.apache.poi.hssf.record.", ""));
/*     */           } 
/*  76 */           System.out.println();
/*     */           
/*  78 */           byte[] arrayOfByte = recordInputStream.readRemainder();
/*  79 */           if (arrayOfByte.length > 0) {
/*  80 */             System.out.print("   ");
/*  81 */             System.out.println(formatData(arrayOfByte));
/*     */           } 
/*     */         } 
/*     */       } finally {
/*  85 */         inputStream.close();
/*     */       } 
/*     */     } finally {
/*  88 */       nPOIFSFileSystem.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String formatSID(int paramInt) {
/*  93 */     String str1 = Integer.toHexString(paramInt);
/*  94 */     String str2 = Integer.toString(paramInt);
/*     */     
/*  96 */     StringBuffer stringBuffer = new StringBuffer();
/*  97 */     stringBuffer.append("0x"); int i;
/*  98 */     for (i = str1.length(); i < 4; i++) {
/*  99 */       stringBuffer.append('0');
/*     */     }
/* 101 */     stringBuffer.append(str1);
/*     */     
/* 103 */     stringBuffer.append(" (");
/* 104 */     for (i = str2.length(); i < 4; i++) {
/* 105 */       stringBuffer.append('0');
/*     */     }
/* 107 */     stringBuffer.append(str2);
/* 108 */     stringBuffer.append(")");
/*     */     
/* 110 */     return stringBuffer.toString();
/*     */   }
/*     */   private static String formatSize(int paramInt) {
/* 113 */     String str1 = Integer.toHexString(paramInt);
/* 114 */     String str2 = Integer.toString(paramInt);
/*     */     
/* 116 */     StringBuffer stringBuffer = new StringBuffer(); int i;
/* 117 */     for (i = str1.length(); i < 3; i++) {
/* 118 */       stringBuffer.append('0');
/*     */     }
/* 120 */     stringBuffer.append(str1);
/*     */     
/* 122 */     stringBuffer.append(" (");
/* 123 */     for (i = str2.length(); i < 3; i++) {
/* 124 */       stringBuffer.append('0');
/*     */     }
/* 126 */     stringBuffer.append(str2);
/* 127 */     stringBuffer.append(")");
/*     */     
/* 129 */     return stringBuffer.toString();
/*     */   }
/*     */   private static String formatData(byte[] paramArrayOfbyte) {
/* 132 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 133 */       return "";
/*     */     }
/*     */     
/* 136 */     StringBuffer stringBuffer = new StringBuffer();
/* 137 */     if (paramArrayOfbyte.length > 9) {
/* 138 */       stringBuffer.append(byteToHex(paramArrayOfbyte[0]));
/* 139 */       stringBuffer.append(' ');
/* 140 */       stringBuffer.append(byteToHex(paramArrayOfbyte[1]));
/* 141 */       stringBuffer.append(' ');
/* 142 */       stringBuffer.append(byteToHex(paramArrayOfbyte[2]));
/* 143 */       stringBuffer.append(' ');
/* 144 */       stringBuffer.append(byteToHex(paramArrayOfbyte[3]));
/* 145 */       stringBuffer.append(' ');
/*     */       
/* 147 */       stringBuffer.append(" .... ");
/*     */       
/* 149 */       stringBuffer.append(' ');
/* 150 */       stringBuffer.append(byteToHex(paramArrayOfbyte[paramArrayOfbyte.length - 4]));
/* 151 */       stringBuffer.append(' ');
/* 152 */       stringBuffer.append(byteToHex(paramArrayOfbyte[paramArrayOfbyte.length - 3]));
/* 153 */       stringBuffer.append(' ');
/* 154 */       stringBuffer.append(byteToHex(paramArrayOfbyte[paramArrayOfbyte.length - 2]));
/* 155 */       stringBuffer.append(' ');
/* 156 */       stringBuffer.append(byteToHex(paramArrayOfbyte[paramArrayOfbyte.length - 1]));
/*     */     } else {
/* 158 */       for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 159 */         stringBuffer.append(byteToHex(paramArrayOfbyte[b]));
/* 160 */         stringBuffer.append(' ');
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     return stringBuffer.toString();
/*     */   }
/*     */   private static String byteToHex(byte paramByte) {
/* 167 */     byte b = paramByte;
/* 168 */     if (b < 0) {
/* 169 */       b += 256;
/*     */     }
/* 171 */     String str = Integer.toHexString(b);
/* 172 */     if (b < 16) {
/* 173 */       return "0" + str;
/*     */     }
/* 175 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFile(String paramString) {
/* 180 */     this.file = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 185 */     if (paramArrayOfString.length == 1 && !paramArrayOfString[0].equals("--help")) {
/*     */       
/* 187 */       RecordLister recordLister = new RecordLister();
/*     */       
/* 189 */       recordLister.setFile(paramArrayOfString[0]);
/* 190 */       recordLister.run();
/*     */     }
/*     */     else {
/*     */       
/* 194 */       System.out.println("RecordLister");
/* 195 */       System.out.println("Outputs the summary of the records in file order");
/*     */       
/* 197 */       System.out.println("usage: java org.apache.poi.hssf.dev.RecordLister filename");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\dev\RecordLister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */