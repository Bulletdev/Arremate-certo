/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IdentifierManager
/*     */ {
/*     */   public static final long MAX_ID = 9223372036854775806L;
/*     */   public static final long MIN_ID = 0L;
/*     */   private final long upperbound;
/*     */   private final long lowerbound;
/*     */   private LinkedList<Segment> segments;
/*     */   
/*     */   public IdentifierManager(long paramLong1, long paramLong2) {
/*  56 */     if (paramLong1 > paramLong2) {
/*  57 */       throw new IllegalArgumentException("lowerbound must not be greater than upperbound, had " + paramLong1 + " and " + paramLong2);
/*     */     }
/*  59 */     if (paramLong1 < 0L) {
/*  60 */       String str = "lowerbound must be greater than or equal to " + Long.toString(0L);
/*  61 */       throw new IllegalArgumentException(str);
/*     */     } 
/*  63 */     if (paramLong2 > 9223372036854775806L)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  68 */       throw new IllegalArgumentException("upperbound must be less than or equal to " + Long.toString(9223372036854775806L) + " but had " + paramLong2);
/*     */     }
/*  70 */     this.lowerbound = paramLong1;
/*  71 */     this.upperbound = paramLong2;
/*  72 */     this.segments = new LinkedList<Segment>();
/*  73 */     this.segments.add(new Segment(paramLong1, paramLong2));
/*     */   }
/*     */   
/*     */   public long reserve(long paramLong) {
/*  77 */     if (paramLong < this.lowerbound || paramLong > this.upperbound) {
/*  78 */       throw new IllegalArgumentException("Value for parameter 'id' was out of bounds, had " + paramLong + ", but should be within [" + this.lowerbound + ":" + this.upperbound + "]");
/*     */     }
/*  80 */     verifyIdentifiersLeft();
/*     */     
/*  82 */     if (paramLong == this.upperbound) {
/*  83 */       Segment segment = this.segments.getLast();
/*  84 */       if (segment.end == this.upperbound) {
/*  85 */         segment.end = this.upperbound - 1L;
/*  86 */         if (segment.start > segment.end) {
/*  87 */           this.segments.removeLast();
/*     */         }
/*  89 */         return paramLong;
/*     */       } 
/*  91 */       return reserveNew();
/*     */     } 
/*     */     
/*  94 */     if (paramLong == this.lowerbound) {
/*  95 */       Segment segment = this.segments.getFirst();
/*  96 */       if (segment.start == this.lowerbound) {
/*  97 */         segment.start = this.lowerbound + 1L;
/*  98 */         if (segment.end < segment.start) {
/*  99 */           this.segments.removeFirst();
/*     */         }
/* 101 */         return paramLong;
/*     */       } 
/* 103 */       return reserveNew();
/*     */     } 
/*     */     
/* 106 */     ListIterator<Segment> listIterator = this.segments.listIterator();
/* 107 */     while (listIterator.hasNext()) {
/* 108 */       Segment segment = listIterator.next();
/* 109 */       if (segment.end < paramLong) {
/*     */         continue;
/*     */       }
/* 112 */       if (segment.start > paramLong) {
/*     */         break;
/*     */       }
/* 115 */       if (segment.start == paramLong) {
/* 116 */         segment.start = paramLong + 1L;
/* 117 */         if (segment.end < segment.start) {
/* 118 */           listIterator.remove();
/*     */         }
/* 120 */         return paramLong;
/*     */       } 
/* 122 */       if (segment.end == paramLong) {
/* 123 */         segment.end = paramLong - 1L;
/* 124 */         if (segment.start > segment.end) {
/* 125 */           listIterator.remove();
/*     */         }
/* 127 */         return paramLong;
/*     */       } 
/*     */       
/* 130 */       listIterator.add(new Segment(paramLong + 1L, segment.end));
/* 131 */       segment.end = paramLong - 1L;
/* 132 */       return paramLong;
/*     */     } 
/*     */     
/* 135 */     return reserveNew();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long reserveNew() {
/* 143 */     verifyIdentifiersLeft();
/* 144 */     Segment segment = this.segments.getFirst();
/* 145 */     long l = segment.start;
/* 146 */     segment.start++;
/* 147 */     if (segment.start > segment.end) {
/* 148 */       this.segments.removeFirst();
/*     */     }
/* 150 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean release(long paramLong) {
/* 161 */     if (paramLong < this.lowerbound || paramLong > this.upperbound) {
/* 162 */       throw new IllegalArgumentException("Value for parameter 'id' was out of bounds, had " + paramLong + ", but should be within [" + this.lowerbound + ":" + this.upperbound + "]");
/*     */     }
/*     */     
/* 165 */     if (paramLong == this.upperbound) {
/* 166 */       Segment segment = this.segments.getLast();
/* 167 */       if (segment.end == this.upperbound - 1L) {
/* 168 */         segment.end = this.upperbound;
/* 169 */         return true;
/* 170 */       }  if (segment.end == this.upperbound) {
/* 171 */         return false;
/*     */       }
/* 173 */       this.segments.add(new Segment(this.upperbound, this.upperbound));
/* 174 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 178 */     if (paramLong == this.lowerbound) {
/* 179 */       Segment segment = this.segments.getFirst();
/* 180 */       if (segment.start == this.lowerbound + 1L) {
/* 181 */         segment.start = this.lowerbound;
/* 182 */         return true;
/* 183 */       }  if (segment.start == this.lowerbound) {
/* 184 */         return false;
/*     */       }
/* 186 */       this.segments.addFirst(new Segment(this.lowerbound, this.lowerbound));
/* 187 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 191 */     long l1 = paramLong + 1L;
/* 192 */     long l2 = paramLong - 1L;
/* 193 */     ListIterator<Segment> listIterator = this.segments.listIterator();
/*     */     
/* 195 */     while (listIterator.hasNext()) {
/* 196 */       Segment segment = listIterator.next();
/* 197 */       if (segment.end < l2) {
/*     */         continue;
/*     */       }
/* 200 */       if (segment.start > l1) {
/* 201 */         listIterator.previous();
/* 202 */         listIterator.add(new Segment(paramLong, paramLong));
/* 203 */         return true;
/*     */       } 
/* 205 */       if (segment.start == l1) {
/* 206 */         segment.start = paramLong;
/* 207 */         return true;
/*     */       } 
/* 209 */       if (segment.end == l2) {
/* 210 */         segment.end = paramLong;
/*     */         
/* 212 */         if (listIterator.hasNext()) {
/* 213 */           Segment segment1 = listIterator.next();
/* 214 */           if (segment1.start == segment.end + 1L) {
/* 215 */             segment.end = segment1.end;
/* 216 */             listIterator.remove();
/*     */           } 
/*     */         } 
/* 219 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     return false;
/*     */   }
/*     */   
/*     */   public long getRemainingIdentifiers() {
/* 230 */     long l = 0L;
/* 231 */     for (Segment segment : this.segments) {
/* 232 */       l -= segment.start;
/* 233 */       l = l + segment.end + 1L;
/*     */     } 
/* 235 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void verifyIdentifiersLeft() {
/* 242 */     if (this.segments.isEmpty())
/* 243 */       throw new IllegalStateException("No identifiers left"); 
/*     */   }
/*     */   
/*     */   private static class Segment { public long start;
/*     */     public long end;
/*     */     
/*     */     public Segment(long param1Long1, long param1Long2) {
/* 250 */       this.start = param1Long1;
/* 251 */       this.end = param1Long2;
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
/*     */     public String toString() {
/* 263 */       return "[" + this.start + "; " + this.end + "]";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\IdentifierManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */