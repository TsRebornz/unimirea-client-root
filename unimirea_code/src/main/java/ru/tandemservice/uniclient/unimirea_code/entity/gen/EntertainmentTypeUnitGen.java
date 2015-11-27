package ru.tandemservice.uniclient.unimirea_code.entity.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import java.util.Date;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Учебное мероприятие
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class EntertainmentTypeUnitGen extends EntityBase
{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit";
    public static final String ENTITY_NAME = "entertainmentTypeUnit";
    public static final int VERSION_HASH = -1534499851;
    private static IEntityMeta ENTITY_META;

    public static final String P_TITILE = "titile";
    public static final String L_TYPE = "type";
    public static final String P_DATE_BEGIN = "dateBegin";
    public static final String P_DATE_END = "dateEnd";
    public static final String P_DESCRIPTION = "description";
    public static final String P_PERIOD = "period";

    private String _titile;     // Название
    private EntertainmentType _type;     // Типы мероприятий
    private Date _dateBegin;     // Дата начала
    private Date _dateEnd;     // Дата окончания
    private String _description;     // Описание

    @Override
    public String toString() {
        return DebugEntityFormatter.INSTANCE.format(this);
    }

    public IEntityMeta getEntityMeta()
    {
        if( ENTITY_META==null )
        {
            ENTITY_META = EntityRuntime.getMeta(ENTITY_NAME);
        }
        return ENTITY_META;
    }

    /**
     * @return Название. Свойство не может быть null.
     */
    @NotNull
    @Length(max=255)
    public String getTitile()
    {
        return _titile;
    }

    /**
     * @param titile Название. Свойство не может быть null.
     */
    public void setTitile(String titile)
    {
        dirty(_titile, titile);
        _titile = titile;
    }

    /**
     * @return Типы мероприятий.
     */
    public EntertainmentType getType()
    {
        return _type;
    }

    /**
     * @param type Типы мероприятий.
     */
    public void setType(EntertainmentType type)
    {
        dirty(_type, type);
        _type = type;
    }

    /**
     * @return Дата начала. Свойство не может быть null.
     */
    @NotNull
    public Date getDateBegin()
    {
        return _dateBegin;
    }

    /**
     * @param dateBegin Дата начала. Свойство не может быть null.
     */
    public void setDateBegin(Date dateBegin)
    {
        dirty(_dateBegin, dateBegin);
        _dateBegin = dateBegin;
    }

    /**
     * @return Дата окончания.
     */
    public Date getDateEnd()
    {
        return _dateEnd;
    }

    /**
     * @param dateEnd Дата окончания.
     */
    public void setDateEnd(Date dateEnd)
    {
        dirty(_dateEnd, dateEnd);
        _dateEnd = dateEnd;
    }

    /**
     * @return Описание.
     */
    public String getDescription()
    {
        return _description;
    }

    /**
     * @param description Описание.
     */
    public void setDescription(String description)
    {
        dirty(_description, description);
        _description = description;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        if (another instanceof EntertainmentTypeUnitGen)
        {
            setTitile(((EntertainmentTypeUnit)another).getTitile());
            setType(((EntertainmentTypeUnit)another).getType());
            setDateBegin(((EntertainmentTypeUnit)another).getDateBegin());
            setDateEnd(((EntertainmentTypeUnit)another).getDateEnd());
            setDescription(((EntertainmentTypeUnit)another).getDescription());
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends EntertainmentTypeUnitGen> extends FastBeanGenBase<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) EntertainmentTypeUnit.class;
        }

        public T newInstance()
        {
            return (T) new EntertainmentTypeUnit();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return obj.getId();
                case "titile":
                    return obj.getTitile();
                case "type":
                    return obj.getType();
                case "dateBegin":
                    return obj.getDateBegin();
                case "dateEnd":
                    return obj.getDateEnd();
                case "description":
                    return obj.getDescription();
            }
            return super.getPropertyValue(obj, propertyName);
        }

        @Override
        public void setPropertyValue(T obj, String propertyName, Object value)
        {
            switch(propertyName)
            {
                case "id":
                    obj.setId((Long) value);
                    return;
                case "titile":
                    obj.setTitile((String) value);
                    return;
                case "type":
                    obj.setType((EntertainmentType) value);
                    return;
                case "dateBegin":
                    obj.setDateBegin((Date) value);
                    return;
                case "dateEnd":
                    obj.setDateEnd((Date) value);
                    return;
                case "description":
                    obj.setDescription((String) value);
                    return;
            }
            super.setPropertyValue(obj, propertyName, value);
        }

        @Override
        public boolean isReadableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                        return true;
                case "titile":
                        return true;
                case "type":
                        return true;
                case "dateBegin":
                        return true;
                case "dateEnd":
                        return true;
                case "description":
                        return true;
            }
            return super.isReadableProperty(propertyName);
        }

        @Override
        public boolean isWritableProperty(String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return true;
                case "titile":
                    return true;
                case "type":
                    return true;
                case "dateBegin":
                    return true;
                case "dateEnd":
                    return true;
                case "description":
                    return true;
            }
            return super.isWritableProperty(propertyName);
        }

        @Override
        public Class getPropertyType(String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return Long.class;
                case "titile":
                    return String.class;
                case "type":
                    return EntertainmentType.class;
                case "dateBegin":
                    return Date.class;
                case "dateEnd":
                    return Date.class;
                case "description":
                    return String.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<EntertainmentTypeUnit> _dslPath = new Path<EntertainmentTypeUnit>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "EntertainmentTypeUnit");
    }
            

    /**
     * @return Название. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getTitile()
     */
    public static PropertyPath<String> titile()
    {
        return _dslPath.titile();
    }

    /**
     * @return Типы мероприятий.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getType()
     */
    public static EntertainmentType.Path<EntertainmentType> type()
    {
        return _dslPath.type();
    }

    /**
     * @return Дата начала. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getDateBegin()
     */
    public static PropertyPath<Date> dateBegin()
    {
        return _dslPath.dateBegin();
    }

    /**
     * @return Дата окончания.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getDateEnd()
     */
    public static PropertyPath<Date> dateEnd()
    {
        return _dslPath.dateEnd();
    }

    /**
     * @return Описание.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getDescription()
     */
    public static PropertyPath<String> description()
    {
        return _dslPath.description();
    }

    /**
     * @EntityDSLSupport
     *
     * @return 
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getPeriod()
     */
    public static SupportedPropertyPath<String> period()
    {
        return _dslPath.period();
    }

    public static class Path<E extends EntertainmentTypeUnit> extends EntityPath<E>
    {
        private PropertyPath<String> _titile;
        private EntertainmentType.Path<EntertainmentType> _type;
        private PropertyPath<Date> _dateBegin;
        private PropertyPath<Date> _dateEnd;
        private PropertyPath<String> _description;
        private SupportedPropertyPath<String> _period;

        public Path()
        {
            super();
        }

        public Path(String path)
        {
            super(path);
        }

        public Path(String childEntityProperty, EntityPath path)
        {
            super(childEntityProperty, path);
        }

    /**
     * @return Название. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getTitile()
     */
        public PropertyPath<String> titile()
        {
            if(_titile == null )
                _titile = new PropertyPath<String>(EntertainmentTypeUnitGen.P_TITILE, this);
            return _titile;
        }

    /**
     * @return Типы мероприятий.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getType()
     */
        public EntertainmentType.Path<EntertainmentType> type()
        {
            if(_type == null )
                _type = new EntertainmentType.Path<EntertainmentType>(L_TYPE, this);
            return _type;
        }

    /**
     * @return Дата начала. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getDateBegin()
     */
        public PropertyPath<Date> dateBegin()
        {
            if(_dateBegin == null )
                _dateBegin = new PropertyPath<Date>(EntertainmentTypeUnitGen.P_DATE_BEGIN, this);
            return _dateBegin;
        }

    /**
     * @return Дата окончания.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getDateEnd()
     */
        public PropertyPath<Date> dateEnd()
        {
            if(_dateEnd == null )
                _dateEnd = new PropertyPath<Date>(EntertainmentTypeUnitGen.P_DATE_END, this);
            return _dateEnd;
        }

    /**
     * @return Описание.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getDescription()
     */
        public PropertyPath<String> description()
        {
            if(_description == null )
                _description = new PropertyPath<String>(EntertainmentTypeUnitGen.P_DESCRIPTION, this);
            return _description;
        }

    /**
     * @EntityDSLSupport
     *
     * @return 
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit#getPeriod()
     */
        public SupportedPropertyPath<String> period()
        {
            if(_period == null )
                _period = new SupportedPropertyPath<String>(EntertainmentTypeUnitGen.P_PERIOD, this);
            return _period;
        }

        public Class getEntityClass()
        {
            return EntertainmentTypeUnit.class;
        }

        public String getEntityName()
        {
            return "entertainmentTypeUnit";
        }

        public Path as(String alias)
        {
            Path path = new Path(getPath());
            path.setAlias(alias);
            return path;
        }

        private Path forAlias(String alias, String root)
        {
            Path path = new Path();
            path.setAlias(alias, root);
            return path;
        }
    }

    public abstract String getPeriod();
}
