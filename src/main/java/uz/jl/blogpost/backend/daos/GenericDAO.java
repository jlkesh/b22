package uz.jl.blogpost.backend.daos;

import com.google.gson.reflect.TypeToken;
import uz.jl.blogpost.backend.domains.Entity;
import uz.jl.blogpost.backend.utils.BaseUtil;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static uz.jl.blogpost.backend.utils.BaseUtil.GSON;

/**
 * @param <T> T -> Domain
 */
public abstract class GenericDAO<T extends Entity> {

    private final Class<T> persistentClass;
    private final String fileName;
    private final List<T> data;
    private final String rootPath = "src/main/resources/%s.json";


    @SuppressWarnings("unchecked")
    protected GenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.fileName = persistentClass.getSimpleName();
        this.data = loadData();

    }


    public T save(T t) {
        data.add(t);
        return t;
    }

    public void shutDownHook() {
        String path = resolvePath();
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(GSON.toJson(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<T> loadData() {
        String path = resolvePath();
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String jsonDATA = bufferedReader.lines().collect(Collectors.joining());
            Type type = new TypeToken<ArrayList<T>>() {
            }.getType();
            return GSON.fromJson(jsonDATA, type);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private String resolvePath() {
        return rootPath.formatted(fileName);
    }


}
