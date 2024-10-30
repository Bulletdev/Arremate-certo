/*     */ package org.apache.xmlbeans.impl.jam;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JamClassIterator
/*     */   implements Iterator
/*     */ {
/*     */   private JamClassLoader mLoader;
/*     */   private String[] mClassNames;
/*  36 */   private int mIndex = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JamClassIterator(JamClassLoader paramJamClassLoader, String[] paramArrayOfString) {
/*  50 */     if (paramJamClassLoader == null) throw new IllegalArgumentException("null loader"); 
/*  51 */     if (paramArrayOfString == null) throw new IllegalArgumentException("null classes"); 
/*  52 */     this.mLoader = paramJamClassLoader;
/*  53 */     this.mClassNames = paramArrayOfString;
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
/*     */   public JClass nextClass() {
/*  66 */     if (!hasNext()) throw new IndexOutOfBoundsException(); 
/*  67 */     this.mIndex++;
/*  68 */     return this.mLoader.loadClass(this.mClassNames[this.mIndex - 1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  78 */     return (this.mIndex < this.mClassNames.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object next() {
/*  88 */     return nextClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize() {
/*  93 */     return this.mClassNames.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 104 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JamClassIterator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */