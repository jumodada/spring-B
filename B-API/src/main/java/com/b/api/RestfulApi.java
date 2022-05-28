package com.b.api;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestfulApi {
    private final Map<Integer, Map<String, Object>> dataMap;
    public RestfulApi(){
        dataMap = new HashMap<>();
        for(int i = 1; i< 3; i++){
            Map<String, Object> data = new HashMap<>();
            data.put("id", i);
            data.put("name", "name" + i);
            dataMap.put(i,data);

        }
    }

    @GetMapping("/getData/${id}")
    public Map<String,Object> getData(@PathVariable Integer id){
        return dataMap.get(id);
    }

    @DeleteMapping("/delete/${id}")
    public void deleteData(@PathVariable Integer id){
         dataMap.remove(id);
    }

    @PostMapping("/post")
    public void posData(@RequestBody Map<String, Object> data){
        Integer[] idArray = dataMap.keySet().toArray(new Integer[0]);
        System.out.println(dataMap.keySet().toArray());
        Arrays.sort(idArray);
        int  nextId = idArray[idArray.length - 1] + 1;
        dataMap.put(nextId, data);
    }

    @PutMapping("/put/${id}")
    public void putData(@RequestBody Map<String, Object> data){
        Integer[] idArray = dataMap.keySet().toArray(new Integer[0]);
        Arrays.sort(idArray);
        int  nextId = idArray[idArray.length - 1] + 1;
        dataMap.put(nextId, data);
    }
}
