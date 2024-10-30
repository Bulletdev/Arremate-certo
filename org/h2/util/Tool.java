/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Properties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.FileLister;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Tool
/*     */ {
/*  28 */   protected PrintStream out = System.out;
/*     */ 
/*     */ 
/*     */   
/*     */   private Properties resources;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOut(PrintStream paramPrintStream) {
/*  38 */     this.out = paramPrintStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void runTool(String... paramVarArgs) throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SQLException showUsageAndThrowUnsupportedOption(String paramString) throws SQLException {
/*  56 */     showUsage();
/*  57 */     throw throwUnsupportedOption(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SQLException throwUnsupportedOption(String paramString) throws SQLException {
/*  68 */     throw DbException.get(50100, paramString).getSQLException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void printNoDatabaseFilesFound(String paramString1, String paramString2) {
/*     */     StringBuilder stringBuilder;
/*  80 */     paramString1 = FileLister.getDir(paramString1);
/*  81 */     if (!FileUtils.isDirectory(paramString1)) {
/*  82 */       stringBuilder = new StringBuilder("Directory not found: ");
/*  83 */       stringBuilder.append(paramString1);
/*     */     } else {
/*  85 */       stringBuilder = new StringBuilder("No database files have been found");
/*  86 */       stringBuilder.append(" in directory ").append(paramString1);
/*  87 */       if (paramString2 != null) {
/*  88 */         stringBuilder.append(" for the database ").append(paramString2);
/*     */       }
/*     */     } 
/*  91 */     this.out.println(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void showUsage() {
/*  99 */     if (this.resources == null) {
/* 100 */       this.resources = new Properties();
/* 101 */       String str1 = "/org/h2/res/javadoc.properties";
/*     */       try {
/* 103 */         byte[] arrayOfByte = Utils.getResource(str1);
/* 104 */         if (arrayOfByte != null) {
/* 105 */           this.resources.load(new ByteArrayInputStream(arrayOfByte));
/*     */         }
/* 107 */       } catch (IOException iOException) {
/* 108 */         this.out.println("Cannot load " + str1);
/*     */       } 
/*     */     } 
/* 111 */     String str = getClass().getName();
/* 112 */     this.out.println(this.resources.get(str));
/* 113 */     this.out.println("Usage: java " + getClass().getName() + " <options>");
/* 114 */     this.out.println(this.resources.get(str + ".main"));
/* 115 */     this.out.println("See also http://h2database.com/javadoc/" + str.replace('.', '/') + ".html");
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
/*     */   public static boolean isOption(String paramString1, String paramString2) {
/* 129 */     if (paramString1.equals(paramString2))
/* 130 */       return true; 
/* 131 */     if (paramString1.startsWith(paramString2)) {
/* 132 */       throw DbException.getUnsupportedException("expected: " + paramString2 + " got: " + paramString1);
/*     */     }
/*     */     
/* 135 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\Tool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */