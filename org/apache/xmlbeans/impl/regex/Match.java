/*     */ package org.apache.xmlbeans.impl.regex;
/*     */ 
/*     */ import java.text.CharacterIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Match
/*     */   implements Cloneable
/*     */ {
/*  32 */   int[] beginpos = null;
/*  33 */   int[] endpos = null;
/*  34 */   int nofgroups = 0;
/*     */   
/*  36 */   CharacterIterator ciSource = null;
/*  37 */   String strSource = null;
/*  38 */   char[] charSource = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Object clone() {
/*  50 */     Match match = new Match();
/*  51 */     if (this.nofgroups > 0) {
/*  52 */       match.setNumberOfGroups(this.nofgroups);
/*  53 */       if (this.ciSource != null) match.setSource(this.ciSource); 
/*  54 */       if (this.strSource != null) match.setSource(this.strSource); 
/*  55 */       for (byte b = 0; b < this.nofgroups; b++) {
/*  56 */         match.setBeginning(b, getBeginning(b));
/*  57 */         match.setEnd(b, getEnd(b));
/*     */       } 
/*     */     } 
/*  60 */     return match;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setNumberOfGroups(int paramInt) {
/*  67 */     int i = this.nofgroups;
/*  68 */     this.nofgroups = paramInt;
/*  69 */     if (i <= 0 || i < paramInt || paramInt * 2 < i) {
/*     */       
/*  71 */       this.beginpos = new int[paramInt];
/*  72 */       this.endpos = new int[paramInt];
/*     */     } 
/*  74 */     for (byte b = 0; b < paramInt; b++) {
/*  75 */       this.beginpos[b] = -1;
/*  76 */       this.endpos[b] = -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSource(CharacterIterator paramCharacterIterator) {
/*  84 */     this.ciSource = paramCharacterIterator;
/*  85 */     this.strSource = null;
/*  86 */     this.charSource = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSource(String paramString) {
/*  92 */     this.ciSource = null;
/*  93 */     this.strSource = paramString;
/*  94 */     this.charSource = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSource(char[] paramArrayOfchar) {
/* 100 */     this.ciSource = null;
/* 101 */     this.strSource = null;
/* 102 */     this.charSource = paramArrayOfchar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setBeginning(int paramInt1, int paramInt2) {
/* 109 */     this.beginpos[paramInt1] = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setEnd(int paramInt1, int paramInt2) {
/* 116 */     this.endpos[paramInt1] = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfGroups() {
/* 124 */     if (this.nofgroups <= 0)
/* 125 */       throw new IllegalStateException("A result is not set."); 
/* 126 */     return this.nofgroups;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBeginning(int paramInt) {
/* 135 */     if (this.beginpos == null)
/* 136 */       throw new IllegalStateException("A result is not set."); 
/* 137 */     if (paramInt < 0 || this.nofgroups <= paramInt) {
/* 138 */       throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + paramInt);
/*     */     }
/* 140 */     return this.beginpos[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEnd(int paramInt) {
/* 149 */     if (this.endpos == null)
/* 150 */       throw new IllegalStateException("A result is not set."); 
/* 151 */     if (paramInt < 0 || this.nofgroups <= paramInt) {
/* 152 */       throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + paramInt);
/*     */     }
/* 154 */     return this.endpos[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCapturedText(int paramInt) {
/*     */     String str;
/* 163 */     if (this.beginpos == null)
/* 164 */       throw new IllegalStateException("match() has never been called."); 
/* 165 */     if (paramInt < 0 || this.nofgroups <= paramInt) {
/* 166 */       throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + paramInt);
/*     */     }
/*     */     
/* 169 */     int i = this.beginpos[paramInt], j = this.endpos[paramInt];
/* 170 */     if (i < 0 || j < 0) return null; 
/* 171 */     if (this.ciSource != null) {
/* 172 */       str = REUtil.substring(this.ciSource, i, j);
/* 173 */     } else if (this.strSource != null) {
/* 174 */       str = this.strSource.substring(i, j);
/*     */     } else {
/* 176 */       str = new String(this.charSource, i, j - i);
/*     */     } 
/* 178 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\Match.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */