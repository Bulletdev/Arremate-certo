/*     */ package org.apache.xmlbeans.impl.jam.internal;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.Vector;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DirectoryScanner
/*     */ {
/*     */   private boolean mCaseSensitive = true;
/*     */   private File mRoot;
/*     */   private JamLogger mLogger;
/*  39 */   private List mIncludeList = null;
/*  40 */   private List mExcludeList = null;
/*     */   private String[] mIncludes;
/*     */   private String[] mExcludes;
/*     */   private Vector mFilesIncluded;
/*     */   private Vector mDirsIncluded;
/*     */   private boolean mIsDirty = false;
/*  46 */   private String[] mIncludedFilesCache = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DirectoryScanner(File paramFile, JamLogger paramJamLogger) {
/*  53 */     if (paramJamLogger == null) throw new IllegalArgumentException("null logger"); 
/*  54 */     this.mLogger = paramJamLogger;
/*  55 */     this.mRoot = paramFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void include(String paramString) {
/*  62 */     if (this.mIncludeList == null) this.mIncludeList = new ArrayList(); 
/*  63 */     this.mIncludeList.add(paramString);
/*  64 */     this.mIsDirty = true;
/*     */   }
/*     */   
/*     */   public void exclude(String paramString) {
/*  68 */     if (this.mExcludeList == null) this.mExcludeList = new ArrayList(); 
/*  69 */     this.mExcludeList.add(paramString);
/*  70 */     this.mIsDirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getIncludedFiles() throws IOException {
/*  79 */     if (!this.mIsDirty && this.mIncludedFilesCache != null) {
/*  80 */       return this.mIncludedFilesCache;
/*     */     }
/*  82 */     if (this.mIncludeList != null) {
/*  83 */       String[] arrayOfString = new String[this.mIncludeList.size()];
/*  84 */       this.mIncludeList.toArray((Object[])arrayOfString);
/*  85 */       setIncludes(arrayOfString);
/*     */     } else {
/*  87 */       setIncludes(null);
/*     */     } 
/*  89 */     if (this.mExcludeList != null) {
/*  90 */       String[] arrayOfString = new String[this.mExcludeList.size()];
/*  91 */       this.mExcludeList.toArray((Object[])arrayOfString);
/*  92 */       setExcludes(arrayOfString);
/*     */     } else {
/*  94 */       setExcludes(null);
/*     */     } 
/*  96 */     scan();
/*  97 */     this.mIncludedFilesCache = new String[this.mFilesIncluded.size()];
/*  98 */     this.mFilesIncluded.copyInto((Object[])this.mIncludedFilesCache);
/*  99 */     return this.mIncludedFilesCache;
/*     */   }
/*     */   
/*     */   public void setDirty() {
/* 103 */     this.mIsDirty = true;
/*     */   }
/*     */   
/*     */   public File getRoot() {
/* 107 */     return this.mRoot;
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
/*     */   private void setIncludes(String[] paramArrayOfString) {
/* 127 */     if (paramArrayOfString == null) {
/* 128 */       this.mIncludes = null;
/*     */     } else {
/* 130 */       this.mIncludes = new String[paramArrayOfString.length];
/* 131 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */         
/* 133 */         String str = paramArrayOfString[b].replace('/', File.separatorChar).replace('\\', File.separatorChar);
/*     */         
/* 135 */         if (str.endsWith(File.separator)) {
/* 136 */           str = str + "**";
/*     */         }
/* 138 */         this.mIncludes[b] = str;
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
/*     */   private void setExcludes(String[] paramArrayOfString) {
/* 157 */     if (paramArrayOfString == null) {
/* 158 */       this.mExcludes = null;
/*     */     } else {
/* 160 */       this.mExcludes = new String[paramArrayOfString.length];
/* 161 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */         
/* 163 */         String str = paramArrayOfString[b].replace('/', File.separatorChar).replace('\\', File.separatorChar);
/*     */         
/* 165 */         if (str.endsWith(File.separator)) {
/* 166 */           str = str + "**";
/*     */         }
/* 168 */         this.mExcludes[b] = str;
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
/*     */   private void scan() throws IllegalStateException, IOException {
/* 184 */     if (this.mIncludes == null) {
/*     */       
/* 186 */       this.mIncludes = new String[1];
/* 187 */       this.mIncludes[0] = "**";
/*     */     } 
/* 189 */     if (this.mExcludes == null) {
/* 190 */       this.mExcludes = new String[0];
/*     */     }
/* 192 */     this.mFilesIncluded = new Vector();
/* 193 */     this.mDirsIncluded = new Vector();
/* 194 */     if (isIncluded("") && 
/* 195 */       !isExcluded("")) {
/* 196 */       this.mDirsIncluded.addElement("");
/*     */     }
/*     */     
/* 199 */     scandir(this.mRoot, "", true);
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
/*     */   private void scandir(File paramFile, String paramString, boolean paramBoolean) throws IOException {
/* 219 */     if (this.mLogger.isVerbose(this)) {
/* 220 */       this.mLogger.verbose("[DirectoryScanner] scanning dir " + paramFile + " for '" + paramString + "'");
/*     */     }
/* 222 */     String[] arrayOfString = paramFile.list();
/* 223 */     if (arrayOfString == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 231 */       throw new IOException("IO error scanning directory " + paramFile.getAbsolutePath());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 261 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 262 */       String str = paramString + arrayOfString[b];
/* 263 */       File file = new File(paramFile, arrayOfString[b]);
/* 264 */       if (file.isDirectory()) {
/* 265 */         if (isIncluded(str) && !isExcluded(str)) {
/* 266 */           this.mDirsIncluded.addElement(str);
/* 267 */           if (this.mLogger.isVerbose(this)) this.mLogger.verbose("...including dir " + str); 
/* 268 */           scandir(file, str + File.separator, paramBoolean);
/*     */         }
/* 270 */         else if (couldHoldIncluded(str)) {
/* 271 */           scandir(file, str + File.separator, paramBoolean);
/*     */         }
/*     */       
/* 274 */       } else if (file.isFile() && 
/* 275 */         isIncluded(str)) {
/* 276 */         if (!isExcluded(str)) {
/* 277 */           this.mFilesIncluded.addElement(str);
/* 278 */           if (this.mLogger.isVerbose(this)) {
/* 279 */             this.mLogger.verbose("...including " + str + " under '" + paramFile);
/*     */           }
/*     */         }
/* 282 */         else if (this.mLogger.isVerbose(this)) {
/* 283 */           this.mLogger.verbose("...EXCLUDING " + str + " under '" + paramFile);
/*     */         } 
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
/*     */   private boolean isIncluded(String paramString) {
/* 300 */     for (byte b = 0; b < this.mIncludes.length; b++) {
/* 301 */       if (matchPath(this.mIncludes[b], paramString, this.mCaseSensitive)) {
/* 302 */         return true;
/*     */       }
/*     */     } 
/* 305 */     return false;
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
/*     */   private boolean couldHoldIncluded(String paramString) {
/* 317 */     for (byte b = 0; b < this.mIncludes.length; b++) {
/* 318 */       if (matchPatternStart(this.mIncludes[b], paramString, this.mCaseSensitive)) {
/* 319 */         return true;
/*     */       }
/*     */     } 
/* 322 */     return false;
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
/*     */   private boolean isExcluded(String paramString) {
/* 334 */     for (byte b = 0; b < this.mExcludes.length; b++) {
/* 335 */       if (matchPath(this.mExcludes[b], paramString, this.mCaseSensitive)) {
/* 336 */         return true;
/*     */       }
/*     */     } 
/* 339 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean matchPatternStart(String paramString1, String paramString2, boolean paramBoolean) {
/* 407 */     if (paramString2.startsWith(File.separator) != paramString1.startsWith(File.separator))
/*     */     {
/* 409 */       return false;
/*     */     }
/* 411 */     Vector vector1 = tokenizePath(paramString1);
/* 412 */     Vector vector2 = tokenizePath(paramString2);
/* 413 */     byte b1 = 0;
/* 414 */     int i = vector1.size() - 1;
/* 415 */     byte b2 = 0;
/* 416 */     int j = vector2.size() - 1;
/*     */     
/* 418 */     while (b1 <= i && b2 <= j) {
/* 419 */       String str = vector1.elementAt(b1);
/* 420 */       if (str.equals("**")) {
/*     */         break;
/*     */       }
/* 423 */       if (!match(str, vector2.elementAt(b2), paramBoolean))
/*     */       {
/* 425 */         return false;
/*     */       }
/* 427 */       b1++;
/* 428 */       b2++;
/*     */     } 
/* 430 */     if (b2 > j)
/*     */     {
/* 432 */       return true; } 
/* 433 */     if (b1 > i)
/*     */     {
/* 435 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 439 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean matchPath(String paramString1, String paramString2, boolean paramBoolean) {
/* 478 */     if (paramString2.startsWith(File.separator) != paramString1.startsWith(File.separator))
/*     */     {
/* 480 */       return false;
/*     */     }
/* 482 */     Vector vector1 = tokenizePath(paramString1);
/* 483 */     Vector vector2 = tokenizePath(paramString2);
/* 484 */     int i = 0;
/* 485 */     int j = vector1.size() - 1;
/* 486 */     int k = 0;
/* 487 */     int m = vector2.size() - 1;
/*     */     
/* 489 */     while (i <= j && k <= m) {
/* 490 */       String str = vector1.elementAt(i);
/* 491 */       if (str.equals("**")) {
/*     */         break;
/*     */       }
/* 494 */       if (!match(str, vector2.elementAt(k), paramBoolean))
/*     */       {
/* 496 */         return false;
/*     */       }
/* 498 */       i++;
/* 499 */       k++;
/*     */     } 
/* 501 */     if (k > m) {
/*     */       
/* 503 */       for (int i1 = i; i1 <= j; i1++) {
/* 504 */         if (!vector1.elementAt(i1).equals("**")) {
/* 505 */           return false;
/*     */         }
/*     */       } 
/* 508 */       return true;
/*     */     } 
/* 510 */     if (i > j)
/*     */     {
/* 512 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 516 */     while (i <= j && k <= m) {
/* 517 */       String str = vector1.elementAt(j);
/* 518 */       if (str.equals("**")) {
/*     */         break;
/*     */       }
/* 521 */       if (!match(str, vector2.elementAt(m), paramBoolean))
/*     */       {
/* 523 */         return false;
/*     */       }
/* 525 */       j--;
/* 526 */       m--;
/*     */     } 
/* 528 */     if (k > m) {
/*     */       
/* 530 */       for (int i1 = i; i1 <= j; i1++) {
/* 531 */         if (!vector1.elementAt(i1).equals("**")) {
/* 532 */           return false;
/*     */         }
/*     */       } 
/* 535 */       return true;
/*     */     } 
/* 537 */     while (i != j && k <= m) {
/* 538 */       int i1 = -1; int i2;
/* 539 */       for (i2 = i + 1; i2 <= j; i2++) {
/* 540 */         if (vector1.elementAt(i2).equals("**")) {
/* 541 */           i1 = i2;
/*     */           break;
/*     */         } 
/*     */       } 
/* 545 */       if (i1 == i + 1) {
/*     */         
/* 547 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 552 */       i2 = i1 - i - 1;
/* 553 */       int i3 = m - k + 1;
/* 554 */       int i4 = -1;
/*     */       
/* 556 */       for (byte b = 0; b <= i3 - i2; ) {
/* 557 */         for (byte b1 = 0; b1 < i2; b1++) {
/* 558 */           String str1 = vector1.elementAt(i + b1 + 1);
/* 559 */           String str2 = vector2.elementAt(k + b + b1);
/* 560 */           if (!match(str1, str2, paramBoolean)) {
/*     */             b++; continue;
/*     */           } 
/*     */         } 
/* 564 */         i4 = k + b;
/*     */       } 
/*     */       
/* 567 */       if (i4 == -1) {
/* 568 */         return false;
/*     */       }
/* 570 */       i = i1;
/* 571 */       k = i4 + i2;
/*     */     } 
/* 573 */     for (int n = i; n <= j; n++) {
/* 574 */       if (!vector1.elementAt(n).equals("**")) {
/* 575 */         return false;
/*     */       }
/*     */     } 
/* 578 */     return true;
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
/*     */   private static boolean match(String paramString1, String paramString2, boolean paramBoolean) {
/* 600 */     char[] arrayOfChar1 = paramString1.toCharArray();
/* 601 */     char[] arrayOfChar2 = paramString2.toCharArray();
/* 602 */     int i = 0;
/* 603 */     int j = arrayOfChar1.length - 1;
/* 604 */     int k = 0;
/* 605 */     int m = arrayOfChar2.length - 1;
/*     */     
/* 607 */     boolean bool = false; int n;
/* 608 */     for (n = 0; n < arrayOfChar1.length; n++) {
/* 609 */       if (arrayOfChar1[n] == '*') {
/* 610 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 614 */     if (!bool) {
/*     */       
/* 616 */       if (j != m) {
/* 617 */         return false;
/*     */       }
/* 619 */       for (n = 0; n <= j; n++) {
/* 620 */         char c1 = arrayOfChar1[n];
/* 621 */         if (c1 != '?') {
/* 622 */           if (paramBoolean && c1 != arrayOfChar2[n]) {
/* 623 */             return false;
/*     */           }
/* 625 */           if (!paramBoolean && Character.toUpperCase(c1) != Character.toUpperCase(arrayOfChar2[n]))
/*     */           {
/* 627 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/* 631 */       return true;
/*     */     } 
/* 633 */     if (j == 0) {
/* 634 */       return true;
/*     */     }
/*     */     char c;
/* 637 */     while ((c = arrayOfChar1[i]) != '*' && k <= m) {
/* 638 */       if (c != '?') {
/* 639 */         if (paramBoolean && c != arrayOfChar2[k]) {
/* 640 */           return false;
/*     */         }
/* 642 */         if (!paramBoolean && Character.toUpperCase(c) != Character.toUpperCase(arrayOfChar2[k]))
/*     */         {
/* 644 */           return false;
/*     */         }
/*     */       } 
/* 647 */       i++;
/* 648 */       k++;
/*     */     } 
/* 650 */     if (k > m) {
/*     */ 
/*     */       
/* 653 */       for (n = i; n <= j; n++) {
/* 654 */         if (arrayOfChar1[n] != '*') {
/* 655 */           return false;
/*     */         }
/*     */       } 
/* 658 */       return true;
/*     */     } 
/*     */     
/* 661 */     while ((c = arrayOfChar1[j]) != '*' && k <= m) {
/* 662 */       if (c != '?') {
/* 663 */         if (paramBoolean && c != arrayOfChar2[m]) {
/* 664 */           return false;
/*     */         }
/* 666 */         if (!paramBoolean && Character.toUpperCase(c) != Character.toUpperCase(arrayOfChar2[m]))
/*     */         {
/* 668 */           return false;
/*     */         }
/*     */       } 
/* 671 */       j--;
/* 672 */       m--;
/*     */     } 
/* 674 */     if (k > m) {
/*     */ 
/*     */       
/* 677 */       for (n = i; n <= j; n++) {
/* 678 */         if (arrayOfChar1[n] != '*') {
/* 679 */           return false;
/*     */         }
/*     */       } 
/* 682 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 686 */     while (i != j && k <= m) {
/* 687 */       n = -1; int i1;
/* 688 */       for (i1 = i + 1; i1 <= j; i1++) {
/* 689 */         if (arrayOfChar1[i1] == '*') {
/* 690 */           n = i1;
/*     */           break;
/*     */         } 
/*     */       } 
/* 694 */       if (n == i + 1) {
/*     */         
/* 696 */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 701 */       i1 = n - i - 1;
/* 702 */       int i2 = m - k + 1;
/* 703 */       int i3 = -1;
/*     */       byte b;
/* 705 */       label117: for (b = 0; b <= i2 - i1; ) {
/* 706 */         for (byte b1 = 0; b1 < i1; b1++) {
/* 707 */           c = arrayOfChar1[i + b1 + 1];
/* 708 */           if (c != '?') {
/* 709 */             if (paramBoolean && c != arrayOfChar2[k + b + b1]) {
/*     */               b++; continue;
/*     */             } 
/* 712 */             if (!paramBoolean && Character.toUpperCase(c) != Character.toUpperCase(arrayOfChar2[k + b + b1])) {
/*     */               continue label117;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 718 */         i3 = k + b;
/*     */       } 
/*     */       
/* 721 */       if (i3 == -1) {
/* 722 */         return false;
/*     */       }
/* 724 */       i = n;
/* 725 */       k = i3 + i1;
/*     */     } 
/*     */ 
/*     */     
/* 729 */     for (n = i; n <= j; n++) {
/* 730 */       if (arrayOfChar1[n] != '*') {
/* 731 */         return false;
/*     */       }
/*     */     } 
/* 734 */     return true;
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
/*     */   private static Vector tokenizePath(String paramString) {
/* 746 */     Vector vector = new Vector();
/* 747 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, File.separator);
/* 748 */     while (stringTokenizer.hasMoreTokens()) {
/* 749 */       vector.addElement(stringTokenizer.nextToken());
/*     */     }
/* 751 */     return vector;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\DirectoryScanner.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */