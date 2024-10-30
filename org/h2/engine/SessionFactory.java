package org.h2.engine;

import java.sql.SQLException;

interface SessionFactory {
  SessionInterface createSession(ConnectionInfo paramConnectionInfo) throws SQLException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\SessionFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */