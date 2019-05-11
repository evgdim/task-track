import { useState } from "react";

export function useFormInput(initialValue: any) {
    const [value, setValue] = useState(initialValue);

    function handleChnage(e: any) {
        setValue(e.target.value)
    }

    return {
        value,
        onChange: handleChnage
    };
}