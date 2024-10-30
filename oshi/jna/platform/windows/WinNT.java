package oshi.jna.platform.windows;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.platform.win32.WinNT;

public interface WinNT extends WinNT {
  @FieldOrder({"TokenIsElevated"})
  public static class TOKEN_ELEVATION extends Structure {
    public int TokenIsElevated;
  }
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\windows\WinNT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */