package com.allong.example.typefilter;

import com.allong.example.annotations.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Properties;

public class DistrictTypeFilter extends AbstractTypeHierarchyTraversingFilter {

    private PathMatcher matcher;

    private String districtName;

    protected DistrictTypeFilter() {
        super(false, false);
        matcher = new AntPathMatcher();

        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
            districtName = properties.getProperty("district.name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean matchClassName(String className) {
        if (!isPotentialPackageClass(className)) {
            return false;
        }
        try {
            Class<?> clazz = ClassUtils.forName(className, DistrictTypeFilter.class.getClassLoader());
            District district = clazz.getAnnotation(District.class);
            if (district == null) {
                return false;
            }
            String districtValue = district.value();
//            System.err.println(districtName + "," + districtValue);
            return !districtValue.equalsIgnoreCase(districtName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("com.allong.example.service.*.*");

    private boolean isPotentialPackageClass(String className) {
        String path = ClassUtils.convertClassNameToResourcePath(className);
        return matcher.match(PATTERN_STANDARD, path);
    }
}
