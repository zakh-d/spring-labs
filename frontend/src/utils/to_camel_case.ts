const toCamelCase = (str: string): string => 
    str.replace(/_([a-z])/g, (_, letter) => letter.toUpperCase());
  
export const mapKeysToCamelCase = <M, N>(data: M): N => {
    if (Array.isArray(data)) {
      return data.map((item) => mapKeysToCamelCase(item)) as unknown as N;
    } else if (data !== null && typeof data === "object") {
      return Object.fromEntries(
        Object.entries(data).map(([key, value]) => [
          toCamelCase(key),
          mapKeysToCamelCase(value),
        ])
      ) as unknown as N;
    }
    return data as unknown as N;
  };