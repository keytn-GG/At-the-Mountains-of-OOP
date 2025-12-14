package scene;

/**
 * 各Sceneがplay()を持つことを約束するinterface
 * play()の詳しい内容は、各Sceneに任せる
 */
public interface Scene {
    //  interfaceの時点でpublicであることは約束されているのでpublicは不要
    Scene play();
}
