/*     */ package org.h2.value;
/*     */ 
/*     */ import com.vividsolutions.jts.geom.CoordinateSequence;
/*     */ import com.vividsolutions.jts.geom.CoordinateSequenceFilter;
/*     */ import com.vividsolutions.jts.geom.Envelope;
/*     */ import com.vividsolutions.jts.geom.Geometry;
/*     */ import com.vividsolutions.jts.geom.GeometryFactory;
/*     */ import com.vividsolutions.jts.geom.PrecisionModel;
/*     */ import com.vividsolutions.jts.io.ParseException;
/*     */ import com.vividsolutions.jts.io.WKBReader;
/*     */ import com.vividsolutions.jts.io.WKBWriter;
/*     */ import com.vividsolutions.jts.io.WKTReader;
/*     */ import com.vividsolutions.jts.io.WKTWriter;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Arrays;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueGeometry
/*     */   extends Value
/*     */ {
/*     */   private final byte[] bytes;
/*     */   private final int hashCode;
/*     */   private Geometry geometry;
/*     */   
/*     */   private ValueGeometry(byte[] paramArrayOfbyte, Geometry paramGeometry) {
/*  60 */     this.bytes = paramArrayOfbyte;
/*  61 */     this.geometry = paramGeometry;
/*  62 */     this.hashCode = Arrays.hashCode(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueGeometry getFromGeometry(Object paramObject) {
/*  73 */     return get((Geometry)paramObject);
/*     */   }
/*     */   
/*     */   private static ValueGeometry get(Geometry paramGeometry) {
/*  77 */     byte[] arrayOfByte = convertToWKB(paramGeometry);
/*  78 */     return (ValueGeometry)Value.cache(new ValueGeometry(arrayOfByte, paramGeometry));
/*     */   }
/*     */   
/*     */   private static byte[] convertToWKB(Geometry paramGeometry) {
/*  82 */     boolean bool = (paramGeometry.getSRID() != 0) ? true : false;
/*  83 */     int i = getDimensionCount(paramGeometry);
/*  84 */     WKBWriter wKBWriter = new WKBWriter(i, bool);
/*  85 */     return wKBWriter.write(paramGeometry);
/*     */   }
/*     */   
/*     */   private static int getDimensionCount(Geometry paramGeometry) {
/*  89 */     ZVisitor zVisitor = new ZVisitor();
/*  90 */     paramGeometry.apply(zVisitor);
/*  91 */     return zVisitor.isFoundZ() ? 3 : 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueGeometry get(String paramString) {
/*     */     try {
/* 102 */       Geometry geometry = (new WKTReader()).read(paramString);
/* 103 */       return get(geometry);
/* 104 */     } catch (ParseException parseException) {
/* 105 */       throw DbException.convert(parseException);
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
/*     */   public static ValueGeometry get(String paramString, int paramInt) {
/*     */     try {
/* 118 */       GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), paramInt);
/* 119 */       Geometry geometry = (new WKTReader(geometryFactory)).read(paramString);
/* 120 */       return get(geometry);
/* 121 */     } catch (ParseException parseException) {
/* 122 */       throw DbException.convert(parseException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueGeometry get(byte[] paramArrayOfbyte) {
/* 133 */     return (ValueGeometry)Value.cache(new ValueGeometry(paramArrayOfbyte, null));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Geometry getGeometry() {
/* 143 */     return (Geometry)getGeometryNoCopy().clone();
/*     */   }
/*     */   
/*     */   public Geometry getGeometryNoCopy() {
/* 147 */     if (this.geometry == null) {
/*     */       try {
/* 149 */         this.geometry = (new WKBReader()).read(this.bytes);
/* 150 */       } catch (ParseException parseException) {
/* 151 */         throw DbException.convert(parseException);
/*     */       } 
/*     */     }
/* 154 */     return this.geometry;
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
/*     */   public boolean intersectsBoundingBox(ValueGeometry paramValueGeometry) {
/* 166 */     return getGeometryNoCopy().getEnvelopeInternal().intersects(paramValueGeometry.getGeometryNoCopy().getEnvelopeInternal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value getEnvelopeUnion(ValueGeometry paramValueGeometry) {
/* 177 */     GeometryFactory geometryFactory = new GeometryFactory();
/* 178 */     Envelope envelope = new Envelope(getGeometryNoCopy().getEnvelopeInternal());
/* 179 */     envelope.expandToInclude(paramValueGeometry.getGeometryNoCopy().getEnvelopeInternal());
/* 180 */     return get(geometryFactory.toGeometry(envelope));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 185 */     return 22;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 193 */     return "X'" + StringUtils.convertBytesToHex(getBytesNoCopy()) + "'::Geometry";
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 198 */     Geometry geometry = ((ValueGeometry)paramValue).getGeometryNoCopy();
/* 199 */     return getGeometryNoCopy().compareTo(geometry);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 204 */     return getWKT();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 209 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 214 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 219 */     return getGeometry();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 224 */     return getWKB();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytesNoCopy() {
/* 229 */     return getWKB();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 235 */     paramPreparedStatement.setObject(paramInt, getGeometryNoCopy());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 240 */     return getWKT().length();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 245 */     return (getWKB()).length * 20 + 24;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 252 */     return (paramObject instanceof ValueGeometry && Arrays.equals(getWKB(), ((ValueGeometry)paramObject).getWKB()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWKT() {
/* 262 */     return (new WKTWriter(3)).write(getGeometryNoCopy());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getWKB() {
/* 271 */     return this.bytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertTo(int paramInt) {
/* 276 */     if (paramInt == 19) {
/* 277 */       return this;
/*     */     }
/* 279 */     return super.convertTo(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   static class ZVisitor
/*     */     implements CoordinateSequenceFilter
/*     */   {
/*     */     boolean foundZ;
/*     */     
/*     */     public boolean isFoundZ() {
/* 289 */       return this.foundZ;
/*     */     }
/*     */ 
/*     */     
/*     */     public void filter(CoordinateSequence param1CoordinateSequence, int param1Int) {
/* 294 */       if (!Double.isNaN(param1CoordinateSequence.getOrdinate(param1Int, 2))) {
/* 295 */         this.foundZ = true;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isDone() {
/* 301 */       return this.foundZ;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isGeometryChanged() {
/* 306 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueGeometry.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */