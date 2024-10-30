/*     */ package org.apache.poi.poifs.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.poifs.filesystem.BlockStore;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DocumentEntry;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.poifs.filesystem.DocumentNode;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSStream;
/*     */ import org.apache.poi.util.IOUtils;
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
/*     */ public class POIFSDump
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*  43 */     if (paramArrayOfString.length == 0) {
/*  44 */       System.err.println("Must specify at least one file to dump");
/*  45 */       System.exit(1);
/*     */     } 
/*     */     
/*  48 */     boolean bool1 = false, bool2 = false;
/*  49 */     for (String str : paramArrayOfString) {
/*  50 */       if (str.equalsIgnoreCase("-dumprops") || str.equalsIgnoreCase("-dump-props") || str.equalsIgnoreCase("-dump-properties")) {
/*     */ 
/*     */         
/*  53 */         bool1 = true;
/*     */       
/*     */       }
/*  56 */       else if (str.equalsIgnoreCase("-dumpmini") || str.equalsIgnoreCase("-dump-mini") || str.equalsIgnoreCase("-dump-ministream") || str.equalsIgnoreCase("-dump-mini-stream")) {
/*     */ 
/*     */ 
/*     */         
/*  60 */         bool2 = true;
/*     */       } else {
/*     */         NPOIFSFileSystem nPOIFSFileSystem;
/*     */         
/*  64 */         System.out.println("Dumping " + str);
/*  65 */         FileInputStream fileInputStream = new FileInputStream(str);
/*     */         
/*     */         try {
/*  68 */           nPOIFSFileSystem = new NPOIFSFileSystem(fileInputStream);
/*     */         } finally {}
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
/*     */   public static void dump(DirectoryEntry paramDirectoryEntry, File paramFile) throws IOException {
/* 101 */     for (Iterator<Entry> iterator = paramDirectoryEntry.getEntries(); iterator.hasNext(); ) {
/* 102 */       Entry entry = iterator.next();
/* 103 */       if (entry instanceof DocumentNode) {
/* 104 */         DocumentNode documentNode = (DocumentNode)entry;
/* 105 */         DocumentInputStream documentInputStream = new DocumentInputStream((DocumentEntry)documentNode);
/* 106 */         byte[] arrayOfByte = IOUtils.toByteArray((InputStream)documentInputStream);
/* 107 */         documentInputStream.close();
/*     */         
/* 109 */         FileOutputStream fileOutputStream = new FileOutputStream(new File(paramFile, documentNode.getName().trim()));
/*     */         try {
/* 111 */           fileOutputStream.write(arrayOfByte);
/*     */         } finally {
/* 113 */           fileOutputStream.close();
/*     */         }  continue;
/* 115 */       }  if (entry instanceof DirectoryEntry) {
/* 116 */         DirectoryEntry directoryEntry = (DirectoryEntry)entry;
/* 117 */         File file = new File(paramFile, entry.getName());
/* 118 */         if (!file.exists() && !file.mkdirs()) {
/* 119 */           throw new IOException("Could not create directory " + file);
/*     */         }
/* 121 */         dump(directoryEntry, file); continue;
/*     */       } 
/* 123 */       System.err.println("Skipping unsupported POIFS entry: " + entry);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void dump(NPOIFSFileSystem paramNPOIFSFileSystem, int paramInt, String paramString, File paramFile) throws IOException {
/* 128 */     File file = new File(paramFile, paramString);
/* 129 */     FileOutputStream fileOutputStream = new FileOutputStream(file);
/*     */     try {
/* 131 */       NPOIFSStream nPOIFSStream = new NPOIFSStream((BlockStore)paramNPOIFSFileSystem, paramInt);
/*     */       
/* 133 */       byte[] arrayOfByte = new byte[paramNPOIFSFileSystem.getBigBlockSize()];
/* 134 */       for (ByteBuffer byteBuffer : nPOIFSStream) {
/* 135 */         int i = byteBuffer.remaining();
/* 136 */         byteBuffer.get(arrayOfByte);
/* 137 */         fileOutputStream.write(arrayOfByte, 0, i);
/*     */       } 
/*     */     } finally {
/* 140 */       fileOutputStream.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\dev\POIFSDump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */