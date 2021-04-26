package ru.samsung.final_project;

import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordList {
    private List<Word> words;

    public WordList(){
        words = new ArrayList<>();
    }

    public List<Word> getWordList() {
        return words;
    }

    public void ForLearnSoftware(){
        words.clear();
        words.add(new Word("a compiler", "[ɑ kəmˈpaɪlə]", "компилятор"));
        words.add(new Word("a database", "[ɑ ˈdeɪtəbeɪs]", "база данных"));
        words.add(new Word("a debugger", "[ɑ diːˈbʌɡə(r)]", "отладчик"));
        words.add(new Word("a desktop application/app", "[ɑ ˈdesktɒp æplɪˈkeɪʃn/æp]", "приложение для настольного компьютера"));
        words.add(new Word("a device driver", "[ɑ dɪˈvaɪs ˈdraɪvə]", "драйвер устройства"));
        words.add(new Word("a graphical user interface (GUI)", "[ɑ 'græfɪkl ˈjuːzər ˈɪntəfeɪs]", "графический пользовательский интерфейс"));
        words.add(new Word("a kernel", "[ɑ kɜːnl]", "ядро"));
        words.add(new Word("a mobile application/app", "[ɑ ˈməʊbaɪl æplɪˈkeɪʃn/æp]", "мобильное приложение"));
        words.add(new Word("a plug-in (plugin)", "[ɑ ˈplʌgɪn]", "плагин, расширение, дополнительный программный модуль"));
        words.add(new Word("a programming language", "[ɑ ˈprəʊgræm ˈlæŋgwɪʤ]", "язык программирования"));
        words.add(new Word("a query", "[ɑ ˈkwɪərɪ]", "запрос"));
        words.add(new Word("a scroll bar", "[ɑ skrəʊl bɑː]", "полоса прокрутки"));
        words.add(new Word("a snapshot", "[ɑ snæpʃɒt]", "снимок состояния системы"));
        words.add(new Word("a spreadsheet", "[ɑ ˈspredʃiːt]", "электронная таблица"));
        words.add(new Word("a status bar", "[ɑ ˈsteɪtəs bɑː]", "строка состояния"));
        words.add(new Word("a template", "[ɑ ˈtemplɪt]", "шаблон"));
        words.add(new Word("a version control system (VCS)", "[ɑ vɜːʃn kɒnˈtrəʊl ˈsɪstɪm]", "система контроля версий"));
        words.add(new Word("a web application", "[ɑ web æplɪˈkeɪʃn]", "веб-приложение"));
        words.add(new Word("a word processor", "[ɑ wɜːd ˈprəʊsesə]", "текстовый процессор"));
        words.add(new Word("a text editor", "[ɑ tekst ˈedɪtə]", "текстовый редактор"));
        words.add(new Word("a utility", "[ɑ juːˈtɪlɪtɪ]", "утилита (служебная программа)"));
        words.add(new Word("acceptance testing", "[əkˈseptəns ˈtestɪŋ]", "приемочное тестирование"));
        words.add(new Word("agile methodology", "[ˈæʤaɪl meθəˈdɒləʤɪ]", "гибкая методология разработки"));
        words.add(new Word("an algorithm", "[ɑn ˈælgərɪðm]", "алгоритм"));
        words.add(new Word("an array", "[ɑn əˈreɪ]", "массив"));
        words.add(new Word("an encoding", "[ɑn ɪnˈkəʊdɪŋ]", "кодировка"));
        words.add(new Word("an enterprise application", "[ɑn ˈentəpraɪz æplɪˈkeɪʃn]", "корпоративное приложение"));
        words.add(new Word("an executable (file)", "[ɑn ɪgˈzekjʊtəbl faɪl]", "исполняемый (файл)"));
        words.add(new Word("an interpreter", "[ɑn ɪnˈtɜːprɪtə]", "интерпретатор"));
        words.add(new Word("an operating system (OS)", "[ɑn ˈɒpə()reɪtɪŋ ()sɪstəm]", "операционная система"));
        words.add(new Word("application software", "[æplɪˈkeɪʃn ˈsɒftweə]", "прикладное программное обеспечение"));
        words.add(new Word("aspect-oriented programming (AOP)", "[ˈæspekt-ˈɔːrɪentɪd ˈprəʊgræmɪŋ]", "аспектно-ориентированное программирование"));
        words.add(new Word("binary data", "[ˈbaɪnərɪ ˈdeɪtə]", "двоичные данные"));
        words.add(new Word("commercial software", "[kəˈmɜːʃəl ˈsɒftweə]", "платное программное обеспечение"));
        words.add(new Word("data", "[ˈdeɪtə]", "данные, информация"));
        words.add(new Word("data processing", "[ˈdeɪtə ˈprəʊsesɪŋ]", "обработка данных"));
        words.add(new Word("extreme programming", "[ɪksˈtriːm ˈprəʊgræmɪŋ]", "экстремальное программирование"));
        words.add(new Word("firmware", "[ˈfɜːmweə]", "прошивка, микропрограмма"));
        words.add(new Word("freeware", "[ˈfriːweər]", "бесплатное программное обеспечение"));
        words.add(new Word("incremental development", "[ɪnkrəˈmentl dɪˈveləpmənt]", "инкрементная модель разработки"));
        words.add(new Word("integrated development environment (IDE)", "[ˈɪntɪgreɪtɪd dɪˈveləpmənt ɪnˈvaɪərənmənt]", "интегрированная среда разработки"));
        words.add(new Word("iterative development", "[ˈɪtərətɪv dɪˈveləpmənt]", "итеративная модель разработки"));
        words.add(new Word("malicious software (malware)", "[məˈlɪʃəs ˈsɒftweə]", "вредоносное программное обеспечение"));
        words.add(new Word("object-oriented programming (OOP)", "[ˈɒbʤɛkt-ˈɔːrɪentɪd ˈprəʊgræmɪŋ]", "объектно-ориентированное программирование"));
        words.add(new Word("open source software", "[ˈəʊpən sɔːs ˈsɒftweə]", "программное обеспечение с открытым исходным кодом"));
        words.add(new Word("prototyping", "[ˈprəʊtətaɪpɪŋ]", "создание прототипа, прототипирование"));
        words.add(new Word("rapid application development (RAD)", "[ˈræpɪd æplɪˈkeɪʃn dɪˈveləpmənt]", "быстрая разработка приложений (методология)"));
        words.add(new Word("regression testing", "[rɪˈgreʃn ˈtestɪŋ]", "регрессионное тестирование"));
        words.add(new Word("runtime (runtime environment)", "[rʌnˈtaɪm]", "среда выполнения кода"));
        words.add(new Word("server software", "[ˈsɜːvə ˈsɒftweə]", "серверное программное обеспечение"));
        words.add(new Word("spiral development", "[ˈspaɪərəl dɪˈveləpmənt]", "спиральная модель разработки"));
        words.add(new Word("spyware", "[ˈspaɪəweər]", "программа-шпион, шпионское программное обеспечение"));
        words.add(new Word("system software", "[ˈsɪstɪm ˈsɒftweə]", "системное программное обеспечение"));
        words.add(new Word("unit testing", "[ˈjuːnɪt ˈtestɪŋ]", "модульное (блочное, компонентное) тестирование"));
        words.add(new Word("waterfall model", "[ˈwɔːtəfɔːl mɒdl]", "каскадная модель разработки"));

        Collections.sort(words);
    }

    public void ForTestSoftware(){
        words.clear();
        words.add(new Word("compiler", "[kəmˈpaɪlə]", "компилятор"));
        words.add(new Word("database", "[ˈdeɪtəbeɪs]", "база данных"));
        words.add(new Word("debugger", "[diːˈbʌɡə(r)]", "отладчик"));
        words.add(new Word("desktop application", "[ˈdesktɒp æplɪˈkeɪʃn/æp]", "приложение для настольного компьютера"));
        words.add(new Word("device driver", "[dɪˈvaɪs ˈdraɪvə]", "драйвер устройства"));
        words.add(new Word("graphical user interface", "['græfɪkl ˈjuːzər ˈɪntəfeɪs]", "графический пользовательский интерфейс"));
        words.add(new Word("kernel", "[kɜːnl]", "ядро"));
        words.add(new Word("mobile application", "[ˈməʊbaɪl æplɪˈkeɪʃn/æp]", "мобильное приложение"));
        words.add(new Word("plugin", "[ˈplʌgɪn]", "плагин, расширение, дополнительный программный модуль"));
        words.add(new Word("programming language", "[ˈprəʊgræm ˈlæŋgwɪʤ]", "язык программирования"));
        words.add(new Word("query", "[ˈkwɪərɪ]", "запрос"));
        words.add(new Word("scroll bar", "[skrəʊl bɑː]", "полоса прокрутки"));
        words.add(new Word("snapshot", "[snæpʃɒt]", "снимок состояния системы"));
        words.add(new Word("spreadsheet", "[ˈspredʃiːt]", "электронная таблица"));
        words.add(new Word("status bar", "[ˈsteɪtəs bɑː]", "строка состояния"));
        words.add(new Word("template", "[ˈtemplɪt]", "шаблон"));
        words.add(new Word("version control system", "[vɜːʃn kɒnˈtrəʊl ˈsɪstɪm]", "система контроля версий"));
        words.add(new Word("web application", "[web æplɪˈkeɪʃn]", "веб-приложение"));
        words.add(new Word("word processor", "[wɜːd ˈprəʊsesə]", "текстовый процессор"));
        words.add(new Word("text editor", "[tekst ˈedɪtə]", "текстовый редактор"));
        words.add(new Word("utility", "[juːˈtɪlɪtɪ]", "утилита (служебная программа)"));
        words.add(new Word("acceptance testing", "[əkˈseptəns ˈtestɪŋ]", "приемочное тестирование"));
        words.add(new Word("agile methodology", "[ˈæʤaɪl meθəˈdɒləʤɪ]", "гибкая методология разработки"));
        words.add(new Word("algorithm", "[ˈælgərɪðm]", "алгоритм"));
        words.add(new Word("array", "[əˈreɪ]", "массив"));
        words.add(new Word("encoding", "[ɪnˈkəʊdɪŋ]", "кодировка"));
        words.add(new Word("enterprise application", "[ˈentəpraɪz æplɪˈkeɪʃn]", "корпоративное приложение"));
        words.add(new Word("executable", "[ɪgˈzekjʊtəbl faɪl]", "исполняемый (файл)"));
        words.add(new Word("interpreter", "[ɪnˈtɜːprɪtə]", "интерпретатор"));
        words.add(new Word("operating system", "[ˈɒpə()reɪtɪŋ ()sɪstəm]", "операционная система"));
        words.add(new Word("application software", "[æplɪˈkeɪʃn ˈsɒftweə]", "прикладное программное обеспечение"));
        words.add(new Word("aspect-oriented programming", "[ˈæspekt-ˈɔːrɪentɪd ˈprəʊgræmɪŋ]", "аспектно-ориентированное программирование"));
        words.add(new Word("binary data", "[ˈbaɪnərɪ ˈdeɪtə]", "двоичные данные"));
        words.add(new Word("commercial software", "[kəˈmɜːʃəl ˈsɒftweə]", "платное программное обеспечение"));
        words.add(new Word("data", "[ˈdeɪtə]", "данные, информация"));
        words.add(new Word("data processing", "[ˈdeɪtə ˈprəʊsesɪŋ]", "обработка данных"));
        words.add(new Word("extreme programming", "[ɪksˈtriːm ˈprəʊgræmɪŋ]", "экстремальное программирование"));
        words.add(new Word("firmware", "[ˈfɜːmweə]", "прошивка, микропрограмма"));
        words.add(new Word("freeware", "[ˈfriːweər]", "бесплатное программное обеспечение"));
        words.add(new Word("incremental development", "[ɪnkrəˈmentl dɪˈveləpmənt]", "инкрементная модель разработки"));
        words.add(new Word("integrated development environment", "[ˈɪntɪgreɪtɪd dɪˈveləpmənt ɪnˈvaɪərənmənt]", "интегрированная среда разработки"));
        words.add(new Word("iterative development", "[ˈɪtərətɪv dɪˈveləpmənt]", "итеративная модель разработки"));
        words.add(new Word("malicious software", "[məˈlɪʃəs ˈsɒftweə]", "вредоносное программное обеспечение"));
        words.add(new Word("object-oriented programming", "[ˈɒbʤɛkt-ˈɔːrɪentɪd ˈprəʊgræmɪŋ]", "объектно-ориентированное программирование"));
        words.add(new Word("open source software", "[ˈəʊpən sɔːs ˈsɒftweə]", "программное обеспечение с открытым исходным кодом"));
        words.add(new Word("prototyping", "[ˈprəʊtətaɪpɪŋ]", "создание прототипа, прототипирование"));
        words.add(new Word("rapid application development", "[ˈræpɪd æplɪˈkeɪʃn dɪˈveləpmənt]", "быстрая разработка приложений (методология)"));
        words.add(new Word("regression testing", "[rɪˈgreʃn ˈtestɪŋ]", "регрессионное тестирование"));
        words.add(new Word("runtime", "[rʌnˈtaɪm]", "среда выполнения кода"));
        words.add(new Word("server software", "[ˈsɜːvə ˈsɒftweə]", "серверное программное обеспечение"));
        words.add(new Word("spiral development", "[ˈspaɪərəl dɪˈveləpmənt]", "спиральная модель разработки"));
        words.add(new Word("spyware", "[ˈspaɪəweər]", "программа-шпион, шпионское программное обеспечение"));
        words.add(new Word("system software", "[ˈsɪstɪm ˈsɒftweə]", "системное программное обеспечение"));
        words.add(new Word("unit testing", "[ˈjuːnɪt ˈtestɪŋ]", "модульное (блочное, компонентное) тестирование"));
        words.add(new Word("waterfall model", "[ˈwɔːtəfɔːl mɒdl]", "каскадная модель разработки"));
    }

    public void ForLearnHardware(){
        words.clear();

        words.add(new Word("a bus", "[ɑ bʌs]", "шина"));
        words.add(new Word("a cable", "[ɑ keɪbl]", "кабель"));
        words.add(new Word("a central processing unit (CPU)", "[ɑ ˈsentrəl ˈprəʊsesɪŋ]", "центральный процессор"));
        words.add(new Word("a computer case", "[ɑ kəmˈpjuːtə keɪs]", "корпус системного блока"));
        words.add(new Word("a device", "[ɑ dɪˈvaɪs]", "устройство"));
        words.add(new Word("a fan", "[ɑ fæn]", "вентилятор охлаждения, кулер"));
        words.add(new Word("a graphics card", "[ɑ ˈgræfɪks kɑːd]", "видеокарта"));
        words.add(new Word("a graphics processing unit (GPU)", "[ɑ ˈgræfɪks ˈprəʊsesɪŋ]", "графический процессор"));
        words.add(new Word("a hard disk drive (HDD)", "[ɑ hɑːd-dɪsk draɪv]", "жесткий диск"));
        words.add(new Word("a laptop", "[ɑ ˈlæptɒp]", "ноутбук, портативный компьютер"));
        words.add(new Word("a light-emitting diode (LED)", "[ɑ laɪt ɪˈmɪtɪŋ ˈdaɪəd]", "светодиод"));
        words.add(new Word("a motherboard (mainboard)", "[ɑ ˈmʌðəbɔːd]", "материнская плата"));
        words.add(new Word("a network card", "[ɑ ˈnetwɜːk kɑːd]", "сетевой адаптер"));
        words.add(new Word("a port", "[ɑ pɔːt]", "разъем, порт"));
        words.add(new Word("a power supply unit (PSU)", "[ɑ ˈpaʊə səˈplaɪ]", "блок питания"));
        words.add(new Word("a solid-state drive (SSD)", "[ɑ ˈsɒlɪd steɪt draɪv]", "твердотельный накопитель"));
        words.add(new Word("a sound card (audio card)", "[ɑ saʊnd kɑːd]", "звуковая карта"));
        words.add(new Word("a storage device", "[ɑ ˈstɔːrɪʤ dɪˈvaɪs]", "запоминающее устройство, накопитель"));
        words.add(new Word("a touch screen", "[ɑ tʌʧ skriːn]", "сенсорный экран"));
        words.add(new Word("air cooling", "[eə ˈkuːlɪŋ]", "воздушное охлаждение"));
        words.add(new Word("an expansion card", "[ɑn ɪksˈpænʃn kɑːd]", "карта (плата) расширения"));
        words.add(new Word("an optical disk drive", "[ɑn ˈɒptɪkəl dɪsk]", "оптический привод"));
        words.add(new Word("an uninterruptible power source (UPS)", "[ɑn ʌnɪntəˈrʌptəbl ˈpaʊə sɔːs]", "источник бесперебойного питания"));
        words.add(new Word("random-access memory (RAM)", "[ˈrændəm ˈækses ˈmemərɪ]", "оперативная память (ОЗУ)"));
        words.add(new Word("read-only memory (ROM)", "[riːd ˈəʊnlɪ ˈmemərɪ]", "постоянное запоминающее устройство (ПЗУ)"));
        words.add(new Word("removable media", "[rɪˈmuːvəbl ˈmedɪə]", "съемные носители информации"));
        words.add(new Word("water cooling", "[ˈwɔːtə ˈkuːlɪŋ]", "водяное охлаждение"));
        words.add(new Word("output devices", "[ˈaʊtpʊt dɪˈvaɪs]", "устройства вывода"));
        words.add(new Word("a monitor", "[ɑ ˈmɒnɪtə]", "монитор"));
        words.add(new Word("a printer", "[ɑ ˈprɪntə]", "принтер"));
        words.add(new Word("a speaker", "[ɑ ˈspiːkə]", "колонка (акустическая)"));
        words.add(new Word("headphones", "[headphones]", "наушники"));
        words.add(new Word("input devices", "[ˈɪnpʊt dɪˈvaɪs]", "устройства ввода"));
        words.add(new Word("a keyboard", "[ɑ ˈkiːbɔːd]", "клавиатура"));
        words.add(new Word("a mouse", "[ɑ maʊs]", "мышь"));
        words.add(new Word("a scanner", "[ɑ ˈskænə]", "сканер"));
        words.add(new Word("a digital camera", "[ɑ ˈdɪʤɪtl ˈkæmərə]", "цифровая камера"));
        words.add(new Word("a joystick", "[ɑ ˈʤɔɪstɪk]", "джойстик"));

        Collections.sort(words);
    }

    public void ForTestHardware(){
        words.clear();

        words.add(new Word("bus", "[bʌs]", "шина"));
        words.add(new Word("cable", "[keɪbl]", "кабель"));
        words.add(new Word("central processing unit", "[ˈsentrəl ˈprəʊsesɪŋ]", "центральный процессор"));
        words.add(new Word("computer case", "[kəmˈpjuːtə keɪs]", "корпус системного блока"));
        words.add(new Word("device", "[dɪˈvaɪs]", "устройство"));
        words.add(new Word("fan", "[fæn]", "вентилятор охлаждения, кулер"));
        words.add(new Word("graphics card", "[ˈgræfɪks kɑːd]", "видеокарта"));
        words.add(new Word("graphics processing unit", "[ˈgræfɪks ˈprəʊsesɪŋ]", "графический процессор"));
        words.add(new Word("hard disk drive", "[hɑːd-dɪsk draɪv]", "жесткий диск"));
        words.add(new Word("laptop", "[ˈlæptɒp]", "ноутбук, портативный компьютер"));
        words.add(new Word("light-emitting diode", "[laɪt ɪˈmɪtɪŋ ˈdaɪəd]", "светодиод"));
        words.add(new Word("motherboard", "[ˈmʌðəbɔːd]", "материнская плата"));
        words.add(new Word("network card", "[ˈnetwɜːk kɑːd]", "сетевой адаптер"));
        words.add(new Word("port", "[pɔːt]", "разъем, порт"));
        words.add(new Word("power supply unit", "[ˈpaʊə səˈplaɪ]", "блок питания"));
        words.add(new Word("solid-state drive", "[ˈsɒlɪd steɪt draɪv]", "твердотельный накопитель"));
        words.add(new Word("sound card (audio card)", "[saʊnd kɑːd]", "звуковая карта"));
        words.add(new Word("storage device", "[ˈstɔːrɪʤ dɪˈvaɪs]", "запоминающее устройство, накопитель"));
        words.add(new Word("touch screen", "[tʌʧ skriːn]", "сенсорный экран"));
        words.add(new Word("air cooling", "[eə ˈkuːlɪŋ]", "воздушное охлаждение"));
        words.add(new Word("expansion card", "[ɪksˈpænʃn kɑːd]", "карта (плата) расширения"));
        words.add(new Word("optical disk drive", "[ˈɒptɪkəl dɪsk]", "оптический привод"));
        words.add(new Word("uninterruptible power source", "[ʌnɪntəˈrʌptəbl ˈpaʊə sɔːs]", "источник бесперебойного питания"));
        words.add(new Word("random-access memory", "[ˈrændəm ˈækses ˈmemərɪ]", "оперативная память (ОЗУ)"));
        words.add(new Word("read-only memory", "[riːd ˈəʊnlɪ ˈmemərɪ]", "постоянное запоминающее устройство (ПЗУ)"));
        words.add(new Word("removable media", "[rɪˈmuːvəbl ˈmedɪə]", "съемные носители информации"));
        words.add(new Word("water cooling", "[ˈwɔːtə ˈkuːlɪŋ]", "водяное охлаждение"));
        words.add(new Word("output devices", "[ˈaʊtpʊt dɪˈvaɪs]", "устройства вывода"));
        words.add(new Word("monitor", "[ˈmɒnɪtə]", "монитор"));
        words.add(new Word("printer", "[ˈprɪntə]", "принтер"));
        words.add(new Word("speaker", "[ˈspiːkə]", "колонка (акустическая)"));
        words.add(new Word("headphones", "[headphones]", "наушники"));
        words.add(new Word("input devices", "[ˈɪnpʊt dɪˈvaɪs]", "устройства ввода"));
        words.add(new Word("keyboard", "[ˈkiːbɔːd]", "клавиатура"));
        words.add(new Word("mouse", "[maʊs]", "мышь"));
        words.add(new Word("scanner", "[ˈskænə]", "сканер"));
        words.add(new Word("digital camera", "[ˈdɪʤɪtl ˈkæmərə]", "цифровая камера"));
        words.add(new Word("joystick", "[ˈʤɔɪstɪk]", "джойстик"));

    }

    public void ForLearnInternet(){
        words.clear();

        words.add(new Word("a bookmark", "[ɑ ˈbʊkmɑːk]", "закладка (в браузере)"));
        words.add(new Word("a bridge", "[ɑ brɪʤ]", "мост"));
        words.add(new Word("a browser", "[ɑ ˈbraʊzə]", "браузер, обозреватель"));
        words.add(new Word("a domain", "[ɑ dəˈmeɪn]", "домен"));
        words.add(new Word("a firewall", "[ɑ ˈfaɪəwɔːl]", "брандмауэр, межсетевой экран"));
        words.add(new Word("a gateway", "[ɑ ˈgeɪtweɪ]", "шлюз"));
        words.add(new Word("a hyperlink", "[ɑ ˈhaɪpəlɪŋk]", "гиперссылка"));
        words.add(new Word("a node", "[ɑ nəʊd]", "узел сети"));
        words.add(new Word("a packet", "[ɑ ˈpækɪt]", "пакет"));
        words.add(new Word("a patch cord", "[ɑ pæʧ kɔːd]", "коммутационный кабель, патч-корд"));
        words.add(new Word("a router", "[ɑ ˈruːtə]", "маршрутизатор, роутер"));
        words.add(new Word("a search engine", "[ɑ sɜːʧ ˈenʤɪn]", "поисковая система"));
        words.add(new Word("a subdomain", "[ɑ səbˈdəʊmeɪn]", "поддомен, субдомен"));
        words.add(new Word("a switch", "[ɑ swɪʧ]", "коммутатор, свитч"));
        words.add(new Word("a website", "[ɑ ˈwebsaɪt]", "веб-сайт, веб-узел"));
        words.add(new Word("a wireless network", "[ɑ ˈwaɪəlɪs ˈnetwɜːk]", "беспроводная сеть"));
        words.add(new Word("bandwidth", "[ˈbændwɪdθ]", "пропускная способность (канала передачи данных)"));
        words.add(new Word("broadband", "[ˈbrɔːdbænd]", "широкополосный доступ в Интернет"));
        words.add(new Word("client-server architecture", "[client-server architecture]", "клиент-серверная архитектура"));
        words.add(new Word("cloud computing", "[klaʊd kəmˈpjuːtɪŋ]", "облачные вычисления"));
        words.add(new Word("cloud storage", "[klaʊd ˈstɔːrɪʤ]", "облачное хранилище данных"));
        words.add(new Word("dynamic host configuration protocol (DHCP)", "[daɪˈnæmɪk həʊst kənfɪgjʊˈreɪʃn ˈprəʊtəkɒl]", "протокол динамической настройки узла"));
        words.add(new Word("domain name system (DNS)", "[dəˈmeɪn neɪm ˈsɪstɪm]", "система доменных имен"));
        words.add(new Word("instant messaging (IM)", "[ˈɪnstənt ˈmesɪʤɪŋ]", "обмен мгновенными сообщениями"));
        words.add(new Word("Internet service provider (ISP)", "[ˈɪntənɛt ˈsɜːvɪs prəˈvaɪdə]", "интернет-провайдер"));
        words.add(new Word("local area network (LAN)", "[ˈləʊkəl ˈe(ə)rɪə ˈnetwɜːk]", "локальная сеть"));
        words.add(new Word("latency", "[ˈleɪtənsɪ]", "задержка, период ожидания"));
        words.add(new Word("media access control (MAC) address", "[media ˈækses kɒnˈtrəʊl əˈdres]", "аппаратный адрес, MAC-адрес"));
        words.add(new Word("peer-to-peer (P2P)", "[peer-to-peer]", "одноранговая сеть, пиринговая сеть"));
        words.add(new Word("twisted pair", "[ˈtwɪstɪd peə]", "витая пара"));
        words.add(new Word("voice over IP (VoIP)", "[voice over IP]", "голосовая связь через Интернет, IP-телефония"));
        words.add(new Word("wide area network (WAN)", "[waɪd ˈe(ə)rɪə ˈnetwɜːk]", "глобальная сеть, широкомасштабная сеть"));

        Collections.sort(words);
    }

    public void ForTestInternet(){
        words.clear();

        words.add(new Word("bookmark", "[ˈbʊkmɑːk]", "закладка (в браузере)"));
        words.add(new Word("bridge", "[brɪʤ]", "мост"));
        words.add(new Word("browser", "[ˈbraʊzə]", "браузер, обозреватель"));
        words.add(new Word("domain", "[dəˈmeɪn]", "домен"));
        words.add(new Word("firewall", "[ˈfaɪəwɔːl]", "брандмауэр, межсетевой экран"));
        words.add(new Word("gateway", "[ˈgeɪtweɪ]", "шлюз"));
        words.add(new Word("hyperlink", "[ˈhaɪpəlɪŋk]", "гиперссылка"));
        words.add(new Word("node", "[nəʊd]", "узел сети"));
        words.add(new Word("packet", "[ˈpækɪt]", "пакет"));
        words.add(new Word("patch cord", "[pæʧ kɔːd]", "коммутационный кабель, патч-корд"));
        words.add(new Word("router", "[ˈruːtə]", "маршрутизатор, роутер"));
        words.add(new Word("search engine", "[sɜːʧ ˈenʤɪn]", "поисковая система"));
        words.add(new Word("subdomain", "[səbˈdəʊmeɪn]", "поддомен, субдомен"));
        words.add(new Word("switch", "[swɪʧ]", "коммутатор, свитч"));
        words.add(new Word("website", "[ˈwebsaɪt]", "веб-сайт, веб-узел"));
        words.add(new Word("wireless network", "[ˈwaɪəlɪs ˈnetwɜːk]", "беспроводная сеть"));
        words.add(new Word("bandwidth", "[ˈbændwɪdθ]", "пропускная способность (канала передачи данных)"));
        words.add(new Word("broadband", "[ˈbrɔːdbænd]", "широкополосный доступ в Интернет"));
        words.add(new Word("client-server architecture", "[client-server architecture]", "клиент-серверная архитектура"));
        words.add(new Word("cloud computing", "[klaʊd kəmˈpjuːtɪŋ]", "облачные вычисления"));
        words.add(new Word("cloud storage", "[klaʊd ˈstɔːrɪʤ]", "облачное хранилище данных"));
        words.add(new Word("dynamic host configuration protocol", "[daɪˈnæmɪk həʊst kənfɪgjʊˈreɪʃn ˈprəʊtəkɒl]", "протокол динамической настройки узла"));
        words.add(new Word("domain name system", "[dəˈmeɪn neɪm ˈsɪstɪm]", "система доменных имен"));
        words.add(new Word("instant messaging", "[ˈɪnstənt ˈmesɪʤɪŋ]", "обмен мгновенными сообщениями"));
        words.add(new Word("Internet service provider", "[ˈɪntənɛt ˈsɜːvɪs prəˈvaɪdə]", "интернет-провайдер"));
        words.add(new Word("local area network", "[ˈləʊkəl ˈe(ə)rɪə ˈnetwɜːk]", "локальная сеть"));
        words.add(new Word("latency", "[ˈleɪtənsɪ]", "задержка, период ожидания"));
        words.add(new Word("media access control address", "[media ˈækses kɒnˈtrəʊl əˈdres]", "аппаратный адрес, MAC-адрес"));
        words.add(new Word("peer-to-peer", "[peer-to-peer]", "одноранговая сеть, пиринговая сеть"));
        words.add(new Word("twisted pair", "[ˈtwɪstɪd peə]", "витая пара"));
        words.add(new Word("voice over IP", "[voice over IP]", "голосовая связь через Интернет, IP-телефония"));
        words.add(new Word("wide area network", "[waɪd ˈe(ə)rɪə ˈnetwɜːk]", "глобальная сеть, широкомасштабная сеть"));

    }

    public void ForLearnGenVerbs(){
        words.clear();

        words.add(new Word("to back up (backup)", "[tuː bæk ʌp]", "выполнять резервное копирование"));
        words.add(new Word("to boot", "[tuː buːt]", "загружать, загружаться"));
        words.add(new Word("to burn", "[tuː bɜːn]", "записывать на оптический диск"));
        words.add(new Word("to create", "[tuː krɪˈeɪt]", "создавать"));
        words.add(new Word("to compile", "[tuː kəmˈpaɪl]", "компилировать"));
        words.add(new Word("to compress", "[tuː ˈkɒmpres]", "сжимать"));
        words.add(new Word("to connect", "[tuː kəˈnekt]", "соединять, подключаться"));
        words.add(new Word("to copy", "[tuː ˈkɒpɪ]", "копировать"));
        words.add(new Word("to cut", "[tuː kʌt]", "вырезать в буфер обмена"));
        words.add(new Word("to debug", "[tuː diːˈbʌg]", "отлаживать"));
        words.add(new Word("to decrypt", "[tuː diːˈkrɪpt]", "расшифровывать"));
        words.add(new Word("to delete", "[tuː dɪˈliːt]", "удалять"));
        words.add(new Word("to deploy", "[tuː dɪˈplɔɪ]", "развертывать"));
        words.add(new Word("to develop", "[tuː dɪˈveləp]", "разрабатывать"));
        words.add(new Word("to disable", "[tuː dɪsˈeɪbl]", "отключать, деактивировать"));
        words.add(new Word("to disconnect", "[tuː dɪskəˈnekt]", "разъединять, отключаться"));
        words.add(new Word("to display", "[tuː dɪsˈpleɪ]", "отображать"));
        words.add(new Word("to download", "[tuː ˈdaʊnləʊd]", "загружать, скачивать"));
        words.add(new Word("to eject", "[tuː ɪˈʤekt]", "извлекать "));
        words.add(new Word("to enable", "[tuː ɪˈneɪbl]", "включать, активировать"));
        words.add(new Word("to encrypt", "[tuː ɪnˈkrɪpt]", "шифровать, зашифровывать"));
        words.add(new Word("to execute", "[tuː ˈeksɪkjuːt]", "исполнять"));
        words.add(new Word("to format", "[tuː ˈfɔːmæt]", "форматировать"));
        words.add(new Word("to implement", "[tuː ˈɪmplɪmənt]", "внедрять, реализовывать"));
        words.add(new Word("to initialize", "[tuː ɪˈnɪʃəlaɪz]", "инициализировать"));
        words.add(new Word("to install", "[tuː ɪnˈstɔːl]", "инсталлировать, устанавливать"));
        words.add(new Word("to integrate", "[tuː ˈɪntɪgrɪt]", "интегрировать, объединять в одну систему"));
        words.add(new Word("to link to", "[tuː lɪŋk tuː]", "ссылаться на что-либо"));
        words.add(new Word("to load", "[tuː ləʊd]", "загружать"));
        words.add(new Word("to paste", "[tuː peɪst]", "вставлять из буфера обмена"));
        words.add(new Word("to plug in", "[tuː plʌg ɪn]", "подключать"));
        words.add(new Word("to press", "[tuː pres]", "нажимать (кнопку)"));
        words.add(new Word("to read", "[tuː riːd]", "считывать"));
        words.add(new Word("to reboot", "[tuː rɪˈbuːt]", "перезагружать, перезагружаться"));
        words.add(new Word("to restore", "[tuː rɪsˈtɔː]", "восстанавливать"));
        words.add(new Word("to save", "[tuː seɪv]", "сохранять"));
        words.add(new Word("to scroll up", "[tuː skrəʊl ʌp]", "прокручивать вверх"));
        words.add(new Word("to scroll down", "[tuː skrəʊl daʊn]", "прокручивать вниз"));
        words.add(new Word("to sort", "[tuː sɔːt]", "сортировать"));
        words.add(new Word("to switch on", "[tuː swɪʧ ɒn]", "включать"));
        words.add(new Word("to switch off", "[tuː swɪʧ ɒf]", "выключать"));
        words.add(new Word("to uninstall", "[tuː ʌnɪnˈstɔːl]", "деинсталлировать, удалять"));
        words.add(new Word("to update", "[tuː ʌpˈdeɪt]", "обновлять"));
        words.add(new Word("to upgrade", "[tuː ˈʌpgreɪd]", "улучшать, модернизировать"));
        words.add(new Word("to upload", "[tuː ʌpˈləʊd]", "загружать, закачивать"));
        words.add(new Word("to verify", "[tuː ˈverɪfaɪ]", "проверять"));

        Collections.sort(words);
    }

    public void ForTestGenVerbs(){
        words.clear();

        words.add(new Word("back up", "[bæk ʌp]", "выполнять резервное копирование"));
        words.add(new Word("boot", "[buːt]", "загружать, загружаться"));
        words.add(new Word("burn", "[bɜːn]", "записывать на оптический диск"));
        words.add(new Word("create", "[krɪˈeɪt]", "создавать"));
        words.add(new Word("compile", "[kəmˈpaɪl]", "компилировать"));
        words.add(new Word("compress", "[ˈkɒmpres]", "сжимать"));
        words.add(new Word("connect", "[kəˈnekt]", "соединять, подключаться"));
        words.add(new Word("copy", "[ˈkɒpɪ]", "копировать"));
        words.add(new Word("cut", "[kʌt]", "вырезать в буфер обмена"));
        words.add(new Word("debug", "[diːˈbʌg]", "отлаживать"));
        words.add(new Word("decrypt", "[diːˈkrɪpt]", "расшифровывать"));
        words.add(new Word("delete", "[dɪˈliːt]", "удалять"));
        words.add(new Word("deploy", "[dɪˈplɔɪ]", "развертывать"));
        words.add(new Word("develop", "[dɪˈveləp]", "разрабатывать"));
        words.add(new Word("disable", "[dɪsˈeɪbl]", "отключать, деактивировать"));
        words.add(new Word("disconnect", "[dɪskəˈnekt]", "разъединять, отключаться"));
        words.add(new Word("display", "[dɪsˈpleɪ]", "отображать"));
        words.add(new Word("download", "[ˈdaʊnləʊd]", "загружать, скачивать"));
        words.add(new Word("eject", "[ɪˈʤekt]", "извлекать "));
        words.add(new Word("enable", "[ɪˈneɪbl]", "включать, активировать"));
        words.add(new Word("encrypt", "[ɪnˈkrɪpt]", "шифровать, зашифровывать"));
        words.add(new Word("execute", "[ˈeksɪkjuːt]", "исполнять"));
        words.add(new Word("format", "[ˈfɔːmæt]", "форматировать"));
        words.add(new Word("implement", "[ˈɪmplɪmənt]", "внедрять, реализовывать"));
        words.add(new Word("initialize", "[ɪˈnɪʃəlaɪz]", "инициализировать"));
        words.add(new Word("install", "[ɪnˈstɔːl]", "инсталлировать, устанавливать"));
        words.add(new Word("integrate", "[ˈɪntɪgrɪt]", "интегрировать, объединять в одну систему"));
        words.add(new Word("link to", "[lɪŋk tuː]", "ссылаться на что-либо"));
        words.add(new Word("load", "[ləʊd]", "загружать"));
        words.add(new Word("paste", "[peɪst]", "вставлять из буфера обмена"));
        words.add(new Word("plug in", "[plʌg ɪn]", "подключать"));
        words.add(new Word("press", "[pres]", "нажимать (кнопку)"));
        words.add(new Word("read", "[riːd]", "считывать"));
        words.add(new Word("reboot", "[rɪˈbuːt]", "перезагружать, перезагружаться"));
        words.add(new Word("restore", "[rɪsˈtɔː]", "восстанавливать"));
        words.add(new Word("save", "[seɪv]", "сохранять"));
        words.add(new Word("scroll up", "[skrəʊl ʌp]", "прокручивать вверх"));
        words.add(new Word("scroll down", "[skrəʊl daʊn]", "прокручивать вниз"));
        words.add(new Word("sort", "[sɔːt]", "сортировать"));
        words.add(new Word("switch on", "[swɪʧ ɒn]", "включать"));
        words.add(new Word("switch off", "[swɪʧ ɒf]", "выключать"));
        words.add(new Word("uninstall", "[ʌnɪnˈstɔːl]", "деинсталлировать, удалять"));
        words.add(new Word("update", "[ʌpˈdeɪt]", "обновлять"));
        words.add(new Word("upgrade", "[ˈʌpgreɪd]", "улучшать, модернизировать"));
        words.add(new Word("upload", "[ʌpˈləʊd]", "загружать, закачивать"));
        words.add(new Word("verify", "[ˈverɪfaɪ]", "проверять"));
    }
}
