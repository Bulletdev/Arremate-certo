/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.LineNumberReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.StringTokenizer;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Tool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConvertTraceFile
/*     */   extends Tool
/*     */ {
/*  32 */   private final HashMap<String, Stat> stats = New.hashMap();
/*     */   
/*     */   private long timeTotal;
/*     */ 
/*     */   
/*     */   static class Stat
/*     */     implements Comparable<Stat>
/*     */   {
/*     */     String sql;
/*     */     int executeCount;
/*     */     long time;
/*     */     long resultCount;
/*     */     
/*     */     public int compareTo(Stat param1Stat) {
/*  46 */       if (param1Stat == this) {
/*  47 */         return 0;
/*     */       }
/*  49 */       int i = MathUtils.compareLong(param1Stat.time, this.time);
/*  50 */       if (i == 0) {
/*  51 */         i = MathUtils.compareInt(param1Stat.executeCount, this.executeCount);
/*  52 */         if (i == 0) {
/*  53 */           i = this.sql.compareTo(param1Stat.sql);
/*     */         }
/*     */       } 
/*  56 */       return i;
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
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  77 */     (new ConvertTraceFile()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  82 */     String str1 = "test.trace.db";
/*  83 */     String str2 = "Test";
/*  84 */     String str3 = "test.sql";
/*  85 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  86 */       String str = paramVarArgs[b];
/*  87 */       if (str.equals("-traceFile"))
/*  88 */       { str1 = paramVarArgs[++b]; }
/*  89 */       else if (str.equals("-javaClass"))
/*  90 */       { str2 = paramVarArgs[++b]; }
/*  91 */       else if (str.equals("-script"))
/*  92 */       { str3 = paramVarArgs[++b]; }
/*  93 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  94 */           showUsage();
/*     */           return;
/*     */         } 
/*  97 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/*     */     try {
/* 101 */       convertFile(str1, str2, str3);
/* 102 */     } catch (IOException iOException) {
/* 103 */       throw DbException.convertIOException(iOException, str1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void convertFile(String paramString1, String paramString2, String paramString3) throws IOException {
/* 112 */     LineNumberReader lineNumberReader = new LineNumberReader(IOUtils.getBufferedReader(FileUtils.newInputStream(paramString1)));
/*     */ 
/*     */     
/* 115 */     PrintWriter printWriter1 = new PrintWriter(IOUtils.getBufferedWriter(FileUtils.newOutputStream(paramString2 + ".java", false)));
/*     */ 
/*     */     
/* 118 */     PrintWriter printWriter2 = new PrintWriter(IOUtils.getBufferedWriter(FileUtils.newOutputStream(paramString3, false)));
/*     */ 
/*     */     
/* 121 */     printWriter1.println("import java.io.*;");
/* 122 */     printWriter1.println("import java.sql.*;");
/* 123 */     printWriter1.println("import java.math.*;");
/* 124 */     printWriter1.println("import java.util.Calendar;");
/* 125 */     String str = paramString2.replace('\\', '/');
/* 126 */     int i = str.lastIndexOf('/');
/* 127 */     if (i > 0) {
/* 128 */       str = str.substring(i + 1);
/*     */     }
/* 130 */     printWriter1.println("public class " + str + " {");
/* 131 */     printWriter1.println("    public static void main(String... args) throws Exception {");
/*     */     
/* 133 */     printWriter1.println("        Class.forName(\"org.h2.Driver\");");
/*     */     while (true) {
/* 135 */       String str1 = lineNumberReader.readLine();
/* 136 */       if (str1 == null) {
/*     */         break;
/*     */       }
/* 139 */       if (str1.startsWith("/**/")) {
/* 140 */         str1 = "        " + str1.substring(4);
/* 141 */         printWriter1.println(str1); continue;
/* 142 */       }  if (str1.startsWith("/*SQL")) {
/* 143 */         int j = str1.indexOf("*/");
/* 144 */         String str2 = str1.substring(j + "*/".length());
/* 145 */         str2 = StringUtils.javaDecode(str2);
/* 146 */         str1 = str1.substring("/*SQL".length(), j);
/* 147 */         if (str1.length() > 0) {
/* 148 */           String str3 = str2;
/* 149 */           int k = 0;
/* 150 */           long l = 0L;
/* 151 */           str1 = str1.trim();
/* 152 */           if (str1.length() > 0) {
/* 153 */             StringTokenizer stringTokenizer = new StringTokenizer(str1, " :");
/* 154 */             while (stringTokenizer.hasMoreElements()) {
/* 155 */               String str4 = stringTokenizer.nextToken();
/* 156 */               if ("l".equals(str4)) {
/* 157 */                 int m = Integer.parseInt(stringTokenizer.nextToken());
/* 158 */                 str3 = str2.substring(0, m) + ";"; continue;
/* 159 */               }  if ("#".equals(str4)) {
/* 160 */                 k = Integer.parseInt(stringTokenizer.nextToken()); continue;
/* 161 */               }  if ("t".equals(str4)) {
/* 162 */                 l = Long.parseLong(stringTokenizer.nextToken());
/*     */               }
/*     */             } 
/*     */           } 
/* 166 */           addToStats(str3, k, l);
/*     */         } 
/* 168 */         printWriter2.println(str2);
/*     */       } 
/*     */     } 
/* 171 */     printWriter1.println("    }");
/* 172 */     printWriter1.println('}');
/* 173 */     lineNumberReader.close();
/* 174 */     printWriter1.close();
/* 175 */     if (this.stats.size() > 0) {
/* 176 */       printWriter2.println("-----------------------------------------");
/* 177 */       printWriter2.println("-- SQL Statement Statistics");
/* 178 */       printWriter2.println("-- time: total time in milliseconds (accumulated)");
/* 179 */       printWriter2.println("-- count: how many times the statement ran");
/* 180 */       printWriter2.println("-- result: total update count or row count");
/* 181 */       printWriter2.println("-----------------------------------------");
/* 182 */       printWriter2.println("-- self accu    time   count  result sql");
/* 183 */       int j = 0;
/* 184 */       ArrayList<Comparable> arrayList = New.arrayList(this.stats.values());
/* 185 */       Collections.sort(arrayList);
/* 186 */       if (this.timeTotal == 0L) {
/* 187 */         this.timeTotal = 1L;
/*     */       }
/* 189 */       for (Stat stat : arrayList) {
/* 190 */         j = (int)(j + stat.time);
/* 191 */         StringBuilder stringBuilder = new StringBuilder(100);
/* 192 */         stringBuilder.append("-- ").append(padNumberLeft(100L * stat.time / this.timeTotal, 3)).append("% ").append(padNumberLeft((100 * j) / this.timeTotal, 3)).append('%').append(padNumberLeft(stat.time, 8)).append(padNumberLeft(stat.executeCount, 8)).append(padNumberLeft(stat.resultCount, 8)).append(' ').append(removeNewlines(stat.sql));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 202 */         printWriter2.println(stringBuilder.toString());
/*     */       } 
/*     */     } 
/* 205 */     printWriter2.close();
/*     */   }
/*     */   
/*     */   private static String removeNewlines(String paramString) {
/* 209 */     return (paramString == null) ? paramString : paramString.replace('\r', ' ').replace('\n', ' ');
/*     */   }
/*     */   
/*     */   private static String padNumberLeft(long paramLong, int paramInt) {
/* 213 */     return StringUtils.pad(String.valueOf(paramLong), paramInt, " ", false);
/*     */   }
/*     */   
/*     */   private void addToStats(String paramString, int paramInt, long paramLong) {
/* 217 */     Stat stat = this.stats.get(paramString);
/* 218 */     if (stat == null) {
/* 219 */       stat = new Stat();
/* 220 */       stat.sql = paramString;
/* 221 */       this.stats.put(paramString, stat);
/*     */     } 
/* 223 */     stat.executeCount++;
/* 224 */     stat.resultCount += paramInt;
/* 225 */     stat.time += paramLong;
/* 226 */     this.timeTotal += paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\ConvertTraceFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */