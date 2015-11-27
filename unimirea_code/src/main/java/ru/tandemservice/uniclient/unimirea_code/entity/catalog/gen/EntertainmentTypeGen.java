package ru.tandemservice.uniclient.unimirea_code.entity.catalog.gen;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.tandemframework.core.common.*;
import org.tandemframework.hibsupport.entity.*;
import ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.entity.*;
import org.tandemframework.core.entity.dsl.*;
import org.tandemframework.core.bean.*;

/**
 * Тип мероприятий
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class EntertainmentTypeGen extends EntityBase
 implements INaturalIdentifiable<EntertainmentTypeGen>, org.tandemframework.common.catalog.entity.ICatalogItem{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType";
    public static final String ENTITY_NAME = "entertainmentType";
    public static final int VERSION_HASH = -976828070;
    private static IEntityMeta ENTITY_META;

    public static final String P_CODE = "code";
    public static final String P_SHORT_TITLE = "shortTitle";
    public static final String P_TITLE = "title";

    private String _code;     // Код
    private String _shortTitle;     // Сокращенное название
    private String _title;     // Название

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
     * @return Код. Свойство не может быть null и должно быть уникальным.
     */
    @NotNull
    @Length(max=255)
    public String getCode()
    {
        return _code;
    }

    /**
     * @param code Код. Свойство не может быть null и должно быть уникальным.
     */
    public void setCode(String code)
    {
        dirty(_code, code);
        _code = code;
    }

    /**
     * @return Сокращенное название. Свойство не может быть null.
     */
    @NotNull
    @Length(max=255)
    public String getShortTitle()
    {
        return _shortTitle;
    }

    /**
     * @param shortTitle Сокращенное название. Свойство не может быть null.
     */
    public void setShortTitle(String shortTitle)
    {
        dirty(_shortTitle, shortTitle);
        _shortTitle = shortTitle;
    }

    /**
     * @return Название.
     */
    @Length(max=1200)
    public String getTitle()
    {
        return _title;
    }

    /**
     * @param title Название.
     */
    public void setTitle(String title)
    {
        dirty(_title, title);
        _title = title;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        if (another instanceof EntertainmentTypeGen)
        {
            if (withNaturalIdProperties)
            {
                setCode(((EntertainmentType)another).getCode());
            }
            setShortTitle(((EntertainmentType)another).getShortTitle());
            setTitle(((EntertainmentType)another).getTitle());
        }
    }

    public INaturalId<EntertainmentTypeGen> getNaturalId()
    {
        return new NaturalId(getCode());
    }

    public static class NaturalId extends NaturalIdBase<EntertainmentTypeGen>
    {
        private static final String PROXY_NAME = "EntertainmentTypeNaturalProxy";

        private String _code;

        public NaturalId()
        {}

        public NaturalId(String code)
        {
            _code = code;
        }

        public String getCode()
        {
            return _code;
        }

        public void setCode(String code)
        {
            _code = code;
        }

        public String getProxyName()
        {
            return PROXY_NAME;
        }

        @Override
        public boolean equals(Object o)
        {
            if( this == o ) return true;
            if( !(o instanceof EntertainmentTypeGen.NaturalId) ) return false;

            EntertainmentTypeGen.NaturalId that = (NaturalId) o;

            if( !equals(getCode(), that.getCode()) ) return false;
            return true;
        }

        @Override
        public int hashCode()
        {
            int result = 0;
            result = hashCode(result, getCode());
            return result;
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder(PROXY_NAME);
            sb.append("/");
            sb.append(getCode());
            return sb.toString();
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends EntertainmentTypeGen> extends FastBeanGenBase<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) EntertainmentType.class;
        }

        public T newInstance()
        {
            return (T) new EntertainmentType();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return obj.getId();
                case "code":
                    return obj.getCode();
                case "shortTitle":
                    return obj.getShortTitle();
                case "title":
                    return obj.getTitle();
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
                case "code":
                    obj.setCode((String) value);
                    return;
                case "shortTitle":
                    obj.setShortTitle((String) value);
                    return;
                case "title":
                    obj.setTitle((String) value);
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
                case "code":
                        return true;
                case "shortTitle":
                        return true;
                case "title":
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
                case "code":
                    return true;
                case "shortTitle":
                    return true;
                case "title":
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
                case "code":
                    return String.class;
                case "shortTitle":
                    return String.class;
                case "title":
                    return String.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<EntertainmentType> _dslPath = new Path<EntertainmentType>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "EntertainmentType");
    }
            

    /**
     * @return Код. Свойство не может быть null и должно быть уникальным.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType#getCode()
     */
    public static PropertyPath<String> code()
    {
        return _dslPath.code();
    }

    /**
     * @return Сокращенное название. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType#getShortTitle()
     */
    public static PropertyPath<String> shortTitle()
    {
        return _dslPath.shortTitle();
    }

    /**
     * @return Название.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType#getTitle()
     */
    public static PropertyPath<String> title()
    {
        return _dslPath.title();
    }

    public static class Path<E extends EntertainmentType> extends EntityPath<E>
    {
        private PropertyPath<String> _code;
        private PropertyPath<String> _shortTitle;
        private PropertyPath<String> _title;

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
     * @return Код. Свойство не может быть null и должно быть уникальным.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType#getCode()
     */
        public PropertyPath<String> code()
        {
            if(_code == null )
                _code = new PropertyPath<String>(EntertainmentTypeGen.P_CODE, this);
            return _code;
        }

    /**
     * @return Сокращенное название. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType#getShortTitle()
     */
        public PropertyPath<String> shortTitle()
        {
            if(_shortTitle == null )
                _shortTitle = new PropertyPath<String>(EntertainmentTypeGen.P_SHORT_TITLE, this);
            return _shortTitle;
        }

    /**
     * @return Название.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.catalog.EntertainmentType#getTitle()
     */
        public PropertyPath<String> title()
        {
            if(_title == null )
                _title = new PropertyPath<String>(EntertainmentTypeGen.P_TITLE, this);
            return _title;
        }

        public Class getEntityClass()
        {
            return EntertainmentType.class;
        }

        public String getEntityName()
        {
            return "entertainmentType";
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
}
