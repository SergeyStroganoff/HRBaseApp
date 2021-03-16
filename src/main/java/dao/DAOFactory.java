package dao;

import config.MainConfig;
import org.apache.log4j.Logger;


public class DAOFactory {

    private static final Logger logger = Logger.getLogger(DAOFactory.class);

    public static ActionDAO getBaseDAO(BaseType type) {

        ActionDAO dao = null;

        switch (type) {
            case FIREBIRD:
                dao = new FireBirdDBDAO();
                break;

            case INTERBASE:
                dao = null; // TODO
                logger.error("Класс подключения к базе Interbase отсутствует");
                break;

            default:
                final String s = "Тип подключения к базе указан неверно";
                logger.error(s);
                throw new IllegalArgumentException(s);
        }
        return dao;
    }

}


