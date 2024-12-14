const toCamelCase = (str: string): string =>
  str.replace(/_([a-z])/g, (_, letter) => letter.toUpperCase());

const toSnakeCase = (str: string): string =>
  str.replace(/[A-Z]/g, (letter) => `_${letter.toLowerCase()}`);

const mapToCase = <M, N>(data: M, converter: (str: string) => string): N => {
  if (Array.isArray(data)) {
    return data.map((item) => mapToCase(item, converter)) as unknown as N;
  } else if (data !== null && typeof data === "object") {
    return Object.fromEntries(
      Object.entries(data).map(([key, value]) => [
        converter(key),
        mapToCase(value, converter),
      ])
    ) as unknown as N;
  }
  return data as unknown as N;
}

export const mapKeysToCamelCase = <M, N>(data: M): N => mapToCase(data, toCamelCase);
export const mapKeysToSnakeCase = <M, N>(data: M): N => mapToCase(data, toSnakeCase);