package org.example.admin.comon.enums;

import org.example.admin.comon.convention.aimodel.AiModelType;

public enum AiModelTypeEnum implements AiModelType {
    /**
     * 豆包模型种类
     */
    Doubao_1_5_vision_pro_32k("doubao-1-5-lite-32k-250115");

    private final String type;

    AiModelTypeEnum(String type) {
        this.type = type;
    }

    @Override
    public String type() {
        return type;
    }
}
