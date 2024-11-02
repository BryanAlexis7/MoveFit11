import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "MoveFit.db" // Nombre de la base de datos
        const val DATABASE_VERSION = 1

        const val TABLE_USERS = "users" // Nombre de la tabla
        const val COLUMN_USER_ID = "id"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_ROUTINE = "routine"
    }

    private val CREATE_TABLE_USERS = """
        CREATE TABLE $TABLE_USERS (
            $COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_USERNAME TEXT,
            $COLUMN_ROUTINE TEXT
        )
    """

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USERS) // Crea la tabla cuando la base de datos es creada
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db) // Recrea la tabla si la versión cambia
    }

    // Método para agregar un usuario
    fun addUser(username: String, routine: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, username)
            put(COLUMN_ROUTINE, routine)
        }
        return db.insert(TABLE_USERS, null, values)
    }

    // Método para obtener todos los usuarios
    fun getAllUsers(): List<Pair<String, String>> {
        val db = this.readableDatabase
        val users = mutableListOf<Pair<String, String>>()
        val cursor = db.query(TABLE_USERS, arrayOf(COLUMN_USERNAME, COLUMN_ROUTINE), null, null, null, null, null)
        with(cursor) {
            while (moveToNext()) {
                val username = getString(getColumnIndexOrThrow(COLUMN_USERNAME))
                val routine = getString(getColumnIndexOrThrow(COLUMN_ROUTINE))
                users.add(Pair(username, routine))
            }
            close()
        }
        return users
    }

    // Método para actualizar la rutina de un usuario
    fun updateUser(id: Long, newRoutine: String): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_ROUTINE, newRoutine)
        }
        return db.update(TABLE_USERS, values, "$COLUMN_USER_ID = ?", arrayOf(id.toString()))
    }

    // Método para eliminar un usuario
    fun deleteUser(id: Long): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_USERS, "$COLUMN_USER_ID = ?", arrayOf(id.toString()))
    }
}
