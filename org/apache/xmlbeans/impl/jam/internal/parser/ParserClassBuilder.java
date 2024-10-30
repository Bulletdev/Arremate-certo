/*     */ package org.apache.xmlbeans.impl.jam.internal.parser;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
/*     */ import org.apache.xmlbeans.impl.jam.provider.ResourcePath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ParserClassBuilder
/*     */   extends JamClassBuilder
/*     */   implements JamClassPopulator
/*     */ {
/*     */   private static final boolean VERBOSE = false;
/*     */   private ResourcePath mSourcePath;
/*     */   private boolean mVerbose = false;
/*  55 */   private PrintWriter mOut = new PrintWriter(System.out);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParserClassBuilder(JamServiceContext paramJamServiceContext) {
/*  63 */     this.mSourcePath = paramJamServiceContext.getInputSourcepath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MClass build(String paramString1, String paramString2) {
/*  71 */     if (paramString1 == null) throw new IllegalArgumentException("null pkg"); 
/*  72 */     if (paramString2 == null) throw new IllegalArgumentException("null name"); 
/*  73 */     String str = paramString1.replace('.', File.separatorChar) + File.separatorChar + paramString2 + ".java";
/*     */     
/*  75 */     if (paramString2.indexOf(".") != -1) {
/*  76 */       throw new IllegalArgumentException("inner classes are NYI at the moment");
/*     */     }
/*  78 */     InputStream inputStream = this.mSourcePath.findInPath(str);
/*  79 */     if (inputStream == null) {
/*  80 */       if (this.mVerbose) {
/*  81 */         this.mOut.println("[ParserClassBuilder] could not find " + str);
/*     */       }
/*  83 */       return null;
/*     */     } 
/*  85 */     if (this.mVerbose) {
/*  86 */       this.mOut.println("[ParserClassBuilder] loading class " + paramString1 + "  " + paramString2);
/*  87 */       this.mOut.println("[ParserClassBuilder] from file " + str);
/*     */     } 
/*     */     
/*  90 */     InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 104 */       inputStreamReader.close();
/* 105 */     } catch (IOException iOException) {
/* 106 */       iOException.printStackTrace();
/*     */     } 
/*     */     
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(MClass paramMClass) {
/* 116 */     throw new IllegalStateException("NYI");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static MClass[] parse(Reader paramReader, JamClassLoader paramJamClassLoader) throws Exception {
/* 123 */     if (paramReader == null) throw new IllegalArgumentException("null in"); 
/* 124 */     if (paramJamClassLoader == null) throw new IllegalArgumentException("null loader");
/*     */ 
/*     */     
/* 127 */     throw new IllegalStateException("temporarily NI");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ParserClassBuilder() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 141 */     (new MainTool()).process(paramArrayOfString);
/*     */   }
/*     */   
/*     */   static class MainTool {
/* 145 */     private List mFailures = new ArrayList();
/* 146 */     private int mCount = 0;
/* 147 */     private PrintWriter mOut = new PrintWriter(System.out);
/* 148 */     private long mStartTime = System.currentTimeMillis();
/*     */     
/*     */     public void process(String[] param1ArrayOfString) {
/*     */       try {
/* 152 */         for (byte b = 0; b < param1ArrayOfString.length; b++) {
/* 153 */           File file = new File(param1ArrayOfString[b]);
/* 154 */           parse(new ParserClassBuilder(), file);
/*     */         } 
/* 156 */       } catch (Exception exception) {
/* 157 */         exception.printStackTrace();
/*     */       } 
/* 159 */       this.mOut.println("\n\n\n");
/* 160 */       int i = this.mFailures.size();
/* 161 */       if (i != 0) {
/* 162 */         this.mOut.println("The following files failed to parse:");
/* 163 */         for (byte b = 0; b < i; b++) {
/* 164 */           this.mOut.println(((File)this.mFailures.get(b)).getAbsolutePath());
/*     */         }
/*     */       } 
/* 167 */       this.mOut.println(((this.mCount - i) * 100 / this.mCount) + "% (" + (this.mCount - i) + "/" + this.mCount + ") " + "of input java files successfully parsed.");
/*     */ 
/*     */       
/* 170 */       this.mOut.println("Total time: " + ((System.currentTimeMillis() - this.mStartTime) / 1000L) + " seconds.");
/*     */ 
/*     */       
/* 173 */       this.mOut.flush();
/* 174 */       System.out.flush();
/* 175 */       System.err.flush();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void parse(ParserClassBuilder param1ParserClassBuilder, File param1File) throws Exception {
/* 181 */       System.gc();
/* 182 */       if (param1File.isDirectory()) {
/*     */         
/* 184 */         File[] arrayOfFile = param1File.listFiles();
/* 185 */         for (byte b = 0; b < arrayOfFile.length; b++) {
/* 186 */           parse(param1ParserClassBuilder, arrayOfFile[b]);
/*     */         }
/*     */       } else {
/* 189 */         if (!param1File.getName().endsWith(".java")) {
/*     */           return;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 195 */         this.mCount++;
/* 196 */         MClass[] arrayOfMClass = null;
/*     */         try {
/* 198 */           arrayOfMClass = ParserClassBuilder.parse(new FileReader(param1File), null);
/* 199 */           if (arrayOfMClass == null) {
/* 200 */             this.mOut.println("[error, parser result is null]");
/* 201 */             addFailure(param1File);
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 210 */         catch (Throwable throwable) {
/* 211 */           throwable.printStackTrace(this.mOut);
/* 212 */           addFailure(param1File);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private void addFailure(File param1File) {
/* 218 */       this.mFailures.add(param1File);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\parser\ParserClassBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */