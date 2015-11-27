package ru.tandemservice.uniclient.unimirea_code.entity.catalog.codes;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

/**
 * Константы кодов сущности "Тип мероприятий"
 * Имя сущности : entertainmentType
 * Файл data.xml : entertainmentType.data.xml
 */
public interface EntertainmentTypeCodes
{
    /** Константа кода (code) элемента : Городская олимпиада (title) */
    String G_O = "1";
    /** Константа кода (code) элемента : Областная олимпиада (title) */
    String O_O = "2";
    /** Константа кода (code) элемента : Всероссийская олимпиада (title) */
    String V_O = "3";
    /** Константа кода (code) элемента : Международная олимпиада (title) */
    String M_O = "4";
    /** Константа кода (code) элемента : Научная конференция (title) */
    String N_K = "5";
    /** Константа кода (code) элемента : Научный семинар (title) */
    String N_S = "6";

    Set<String> CODES = ImmutableSet.of(G_O, O_O, V_O, M_O, N_K, N_S);
}
