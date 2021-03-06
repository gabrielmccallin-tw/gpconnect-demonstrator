
export const domainOptions = {
    gpconnect: 'gpconnect',
    migrator: 'migrator',
    none: 'none'
};

const features = {
    api: domainOptions.none
};

export const setFeatures = (featuresToSet: { [s: string]: unknown; } | ArrayLike<unknown>) => {
    Object.entries(featuresToSet).forEach(([key, value]) => {
        features[key] = value;
    });
};

export const api = () => {
    return features.api;
};