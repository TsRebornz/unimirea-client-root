package ru.tandemservice.uniclient.unimirea_code.entity.gen;

import org.tandemframework.core.bean.FastBeanGenBase;
import org.tandemframework.core.bean.IFastBean;
import org.tandemframework.core.entity.EntityBase;
import org.tandemframework.core.entity.IEntity;
import org.tandemframework.core.entity.dsl.EntityPath;
import org.tandemframework.core.entity.dsl.PropertyPath;
import org.tandemframework.core.entity.dsl.SupportedPropertyPath;
import org.tandemframework.core.meta.entity.IEntityMeta;
import org.tandemframework.core.runtime.EntityRuntime;
import org.tandemframework.core.view.formatter.DebugEntityFormatter;
import org.tandemframework.shared.employeebase.base.entity.EmployeePost;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption;
import ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentTypeUnit;

import javax.validation.constraints.NotNull;

/**
 * Участие во внеучебном мероприятии
 */
@SuppressWarnings({"all", "unchecked", "unused", "deprecation"})
public abstract class EntertainmentPrtcptionGen extends EntityBase
{
    public static final IFastBean FAST_BEAN = new FastBean();

    public static final String ENTITY_CLASS = "ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption";
    public static final String ENTITY_NAME = "entertainmentPrtcption";
    public static final int VERSION_HASH = 475540536;
    private static IEntityMeta ENTITY_META;

    public static final String L_UNIT = "unit";
    public static final String L_TYPE = "type";
    public static final String P_OVERSEER = "overseer";
    public static final String P_FULL_ENTERTAINMENT_NAME = "fullEntertainmentName";
    public static final String P_OVERSEER_AS_STRING = "overseerAsString";

    private EntertainmentTypeUnit _unit;     // Мероприятие
    private EmployeePost _type;     // Участник
    private boolean _overseer;     // Наблюдатель

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
     * @return Мероприятие. Свойство не может быть null.
     */
    @NotNull
    public EntertainmentTypeUnit getUnit()
    {
        return _unit;
    }

    /**
     * @param unit Мероприятие. Свойство не может быть null.
     */
    public void setUnit(EntertainmentTypeUnit unit)
    {
        dirty(_unit, unit);
        _unit = unit;
    }

    /**
     * @return Участник. Свойство не может быть null.
     */
    @NotNull
    public EmployeePost getType()
    {
        return _type;
    }

    /**
     * @param type Участник. Свойство не может быть null.
     */
    public void setType(EmployeePost type)
    {
        dirty(_type, type);
        _type = type;
    }

    /**
     * @return Наблюдатель. Свойство не может быть null.
     */
    @NotNull
    public boolean isOverseer()
    {
        return _overseer;
    }

    /**
     * @param overseer Наблюдатель. Свойство не может быть null.
     */
    public void setOverseer(boolean overseer)
    {
        dirty(_overseer, overseer);
        _overseer = overseer;
    }

    public void update(IEntity another)
    {
        update(another, true);
    }

    public void update(IEntity another, boolean withNaturalIdProperties)
    {
        if (another instanceof EntertainmentPrtcptionGen)
        {
            setUnit(((EntertainmentPrtcption)another).getUnit());
            setType(((EntertainmentPrtcption)another).getType());
            setOverseer(((EntertainmentPrtcption)another).isOverseer());
        }
    }

    @Override
    public IFastBean getFastBean()
    {
        return FAST_BEAN;
    }

    protected static class FastBean<T extends EntertainmentPrtcptionGen> extends FastBeanGenBase<T>    {
        public Class<T> getBeanClass()
        {
            return (Class<T>) EntertainmentPrtcption.class;
        }

        public T newInstance()
        {
            return (T) new EntertainmentPrtcption();
        }
        @Override
        public Object getPropertyValue(T obj, String propertyName)
        {
            switch(propertyName)
            {
                case "id":
                    return obj.getId();
                case "unit":
                    return obj.getUnit();
                case "type":
                    return obj.getType();
                case "overseer":
                    return obj.isOverseer();
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
                case "unit":
                    obj.setUnit((EntertainmentTypeUnit) value);
                    return;
                case "type":
                    obj.setType((EmployeePost) value);
                    return;
                case "overseer":
                    obj.setOverseer((Boolean) value);
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
                case "unit":
                        return true;
                case "type":
                        return true;
                case "overseer":
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
                case "unit":
                    return true;
                case "type":
                    return true;
                case "overseer":
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
                case "unit":
                    return EntertainmentTypeUnit.class;
                case "type":
                    return EmployeePost.class;
                case "overseer":
                    return Boolean.class;
            }
            return super.getPropertyType(propertyName);
        }
    }
    private static final Path<EntertainmentPrtcption> _dslPath = new Path<EntertainmentPrtcption>();

    public static Path as(String alias)
    {
        return _dslPath.forAlias(alias, "EntertainmentPrtcption");
    }
            

    /**
     * @return Мероприятие. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getUnit()
     */
    public static EntertainmentTypeUnit.Path<EntertainmentTypeUnit> unit()
    {
        return _dslPath.unit();
    }

    /**
     * @return Участник. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getType()
     */
    public static EmployeePost.Path<EmployeePost> type()
    {
        return _dslPath.type();
    }

    /**
     * @return Наблюдатель. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#isOverseer()
     */
    public static PropertyPath<Boolean> overseer()
    {
        return _dslPath.overseer();
    }

    /**
     * @EntityDSLSupport
     *
     * @return 
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getFullEntertainmentName()
     */
    public static SupportedPropertyPath<String> fullEntertainmentName()
    {
        return _dslPath.fullEntertainmentName();
    }

    /**
     * @EntityDSLSupport
     *
     * @return 
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getOverseerAsString()
     */
    public static SupportedPropertyPath<String> overseerAsString()
    {
        return _dslPath.overseerAsString();
    }

    public static class Path<E extends EntertainmentPrtcption> extends EntityPath<E>
    {
        private EntertainmentTypeUnit.Path<EntertainmentTypeUnit> _unit;
        private EmployeePost.Path<EmployeePost> _type;
        private PropertyPath<Boolean> _overseer;
        private SupportedPropertyPath<String> _fullEntertainmentName;
        private SupportedPropertyPath<String> _overseerAsString;

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
     * @return Мероприятие. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getUnit()
     */
        public EntertainmentTypeUnit.Path<EntertainmentTypeUnit> unit()
        {
            if(_unit == null )
                _unit = new EntertainmentTypeUnit.Path<EntertainmentTypeUnit>(L_UNIT, this);
            return _unit;
        }

    /**
     * @return Участник. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getType()
     */
        public EmployeePost.Path<EmployeePost> type()
        {
            if(_type == null )
                _type = new EmployeePost.Path<EmployeePost>(L_TYPE, this);
            return _type;
        }

    /**
     * @return Наблюдатель. Свойство не может быть null.
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#isOverseer()
     */
        public PropertyPath<Boolean> overseer()
        {
            if(_overseer == null )
                _overseer = new PropertyPath<Boolean>(EntertainmentPrtcptionGen.P_OVERSEER, this);
            return _overseer;
        }

    /**
     * @EntityDSLSupport
     *
     * @return 
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getFullEntertainmentName()
     */
        public SupportedPropertyPath<String> fullEntertainmentName()
        {
            if(_fullEntertainmentName == null )
                _fullEntertainmentName = new SupportedPropertyPath<String>(EntertainmentPrtcptionGen.P_FULL_ENTERTAINMENT_NAME, this);
            return _fullEntertainmentName;
        }

    /**
     * @EntityDSLSupport
     *
     * @return 
     * @see ru.tandemservice.uniclient.unimirea_code.entity.EntertainmentPrtcption#getOverseerAsString()
     */
        public SupportedPropertyPath<String> overseerAsString()
        {
            if(_overseerAsString == null )
                _overseerAsString = new SupportedPropertyPath<String>(EntertainmentPrtcptionGen.P_OVERSEER_AS_STRING, this);
            return _overseerAsString;
        }

        public Class getEntityClass()
        {
            return EntertainmentPrtcption.class;
        }

        public String getEntityName()
        {
            return "entertainmentPrtcption";
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

    public abstract String getFullEntertainmentName();

    public abstract String getOverseerAsString();
}
