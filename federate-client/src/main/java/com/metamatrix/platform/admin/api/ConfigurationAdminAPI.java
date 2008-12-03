/*
 * JBoss, Home of Professional Open Source.
 * Copyright (C) 2008 Red Hat, Inc.
 * Copyright (C) 2000-2007 MetaMatrix, Inc.
 * Licensed to Red Hat, Inc. under one or more contributor 
 * license agreements.  See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package com.metamatrix.platform.admin.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.metamatrix.api.exception.MetaMatrixComponentException;
import com.metamatrix.api.exception.security.AuthorizationException;
import com.metamatrix.api.exception.security.InvalidSessionException;
import com.metamatrix.common.actions.ActionDefinition;
import com.metamatrix.common.actions.ModificationException;
import com.metamatrix.common.config.api.ComponentDefn;
import com.metamatrix.common.config.api.ComponentDefnID;
import com.metamatrix.common.config.api.ComponentType;
import com.metamatrix.common.config.api.ComponentTypeID;
import com.metamatrix.common.config.api.Configuration;
import com.metamatrix.common.config.api.ConfigurationID;
import com.metamatrix.common.config.api.ConfigurationModelContainer;
import com.metamatrix.common.config.api.ConfigurationObjectEditor;
import com.metamatrix.common.config.api.Host;
import com.metamatrix.common.config.api.HostID;
import com.metamatrix.common.config.api.ResourceDescriptor;
import com.metamatrix.common.config.api.exceptions.ConfigurationException;
import com.metamatrix.common.config.api.exceptions.ConfigurationLockException;
import com.metamatrix.common.config.api.exceptions.InvalidConfigurationException;


public interface ConfigurationAdminAPI extends SubSystemAdminAPI {

    /**
     *  Returns a <code>ConfigurationObjectEditor</code> to perform editing operations
     *  on a configuration type object.  The editing process will create actions for
     *  each specific type of editing operation.  Those actions are what need to be
     *  submitted to the <code>ConfigurationService</code> for actual updates to occur.
     *  @return ConfigurationObjectEditor
     */
    ConfigurationObjectEditor createEditor()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the <code>ConfigurationID</code> for the current configuration.
     * @return ConfigurationID for current configuration
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @throws InvalidSessionException if there is not a valid administrative session
     * @throws AuthorizationException if the administrator does not have privileges to use this method
     * @throws MetaMatrixComponentException if a general remote system problem occurred
     */
    ConfigurationID getCurrentConfigurationID()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the ID of the next startup <code>Configuration</code>, which should reflect
     * the desired runtime state of the system.
     * @return ID of next startup configuration
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @throws InvalidSessionException if there is not a valid administrative session
     * @throws AuthorizationException if the administrator does not have privileges to use this method
     * @throws MetaMatrixComponentException if a general remote system problem occurred
     */
    ConfigurationID getNextStartupConfigurationID()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the ID of the startup <code>Configuration</code>, which should reflect
     * the desired runtime state of the system.
     * @return ID of startup configuration
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @throws InvalidSessionException if there is not a valid administrative session
     * @throws AuthorizationException if the administrator does not have privileges to use this method
     * @throws MetaMatrixComponentException if a general remote system problem occurred
     */
    ConfigurationID getStartupConfigurationID()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the current deployed <code>Configuration</code>.  Note, this configuration
     * may not match the actual configuration the system is currently executing under due
     * to administrative task that can be done to tune the system.  Those administrative
     * task <b>do not</b> change the actual <code>Configuration</code> stored in the
     * <code>ConfigurationService</code>.
     * @return Configuration that is currently in use
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Configuration getCurrentConfiguration()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the current deployed <code>Configuration</code>.  Note, this configuration
     * may not match the actual configuration the system is currently executing under due
     * to administrative task that can be done to tune the system.  Those administrative
     * task <b>do not</b> change the actual <code>Configuration</code> stored in the
     * <code>ConfigurationService</code>.
     * @return Configuration that is currently in use
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Configuration getNextStartupConfiguration()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the current deployed <code>Configuration</code>.  Note, this configuration
     * may not match the actual configuration the system is currently executing under due
     * to administrative task that can be done to tune the system.  Those administrative
     * task <b>do not</b> change the actual <code>Configuration</code> stored in the
     * <code>ConfigurationService</code>.
     * @return Configuration that is currently in use
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Configuration getStartupConfiguration()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the named <code>Configuration</code>.
     * @param configName is the name of the Configuration to obtain
     * @return Configuration
     * @throws InvalidConfigurationException if the specified name does not exist
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Configuration getConfiguration(String configName)
    throws InvalidConfigurationException, ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns the current <code>ConfigurationModelContainer</code>.  Note, this configuration
     * may not match the actual configuration the system is currently executing under due
     * to administrative task that can be done to tune the system.  Those administrative
     * task <b>do not</b> change the actual <code>Configuration</code> stored in the
     * <code>ConfigurationService</code>.
     * @param configName is the name of the Configuration model to obtain
     * @return Configuration that is currently in use
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    ConfigurationModelContainer getConfigurationModel(String configName)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;



    /**
     * <p>Returns a Collection containing the Configuration object for the specified
     * ConfigurationID id, and also any dependant objects needed to fully
     * define this configuration, such as Host objects, ComponentType
     * objects, and ComponentTypeDefn objects.</p>
     *
     * <p>A Configuration instance contains all of the
     * <code>ComponentDefn</code> objects that "belong" to just that
     * Configuration: VM component definitions, service
     * component definitions, product service configurations, and
     * deployed components.  Objects such as Host objects,
     * ComponentType objects, and ComponentTypeDefn objects describe
     * ComponentDefns, but are not contained by a Configuration.  Therefore,
     * they are included in this Collection for convenience.</p>
     *
     * <p>The Collection will contain instances of
     * {@link com.metamatrix.common.namedobject.BaseObject}.
     * Specifically, this Map should contain the objects for:
     * one configuration object, one or more Host objects, one or more
     * ComponentType objects, and one or more ComponentTypeDefn objects.</p>
     *
     * <p>This method is intended to facilitate exporting a configuration
     * to XML.</p>
     *
     * <p>Here is what the Collection would contain at runtime:
     * <pre>
     * Configuration instance
     * Host instance1
     * Host instance2
     * ...
     * ComponentType instance1
     * ComponentType instance2
     * ...
     * ComponentTypeDefn instance1
     * ComponentTypeDefn instance2
     * </pre></p>
     *
     * @param configID ID Of a Configuration
     * @return Collection of BaseObject instances
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @throws InvalidSessionException if there is not a valid administrative session
     * @throws AuthorizationException if the administrator does not have privileges to use this method
     * @throws MetaMatrixComponentException if a general remote system problem occurred
     */
    Collection getConfigurationAndDependents(ConfigurationID configID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
    * <p>This method will return a Collection of objects that represent the 
    * set of global configuration objects currently represented in the
    * configuration database.  This method will generally be used when
    * attempting to import a configuration into the database as the 'Next Startup' 
    * configuration.  This information is important when importing a new configuration
    * so that any global type configuration objects that are to be imported can
    * be resolved against the global objects that currently exist in the
    * database.</p>
    *
    * <pre>
    * The Collection of objects will contain the following configuration 
    * object types:
    * 
    * ComponentTypes
    * ProductTypes
    * Hosts
    * </pre>
    *
    * @return a Collection of all of the global configuration objects as they
    * exist in the database.
    * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
    * @throws InvalidSessionException if there is not a valid administrative session
    * @throws AuthorizationException if the administrator does not have privileges to use this method
    * @throws MetaMatrixComponentException if a general remote system problem occurred
    */
    public Collection getAllGlobalConfigObjects()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Baselines the realtime portion of the current (operational) configuration into the
     * next-startup configuration.
     */
    void baselineCurrentConfiguration()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     *   Returns a Map of component type definitions for each <code>ComponentTypeID</code>
     *   that is contained in the passed <code>Collection</code>.  This does not
     *   return the dependent definitions for service type components.
     *   @param componentIDs is a Collection
     *   @return Map of a Map of component type difinitions keyed by <code>ComponentTypeID</code>
     *
     *   @see getDependentComponentTypeDefintions(Collection)
     */
    Map getComponentTypeDefinitions(Collection componentIDs)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     *   Returns the component type definitions for the specified <code>ComponentTypeID</code>.
     *   This does not return the dependent definitions for service type components.
     *   @param componentTypeID is a ComponentTypeID
     *   @return Collection of ComponentTypeDefns
     *
     *   @see getDependentComponentTypeDefinitions(ComponentTypeID)
     */
    Collection getComponentTypeDefinitions(ComponentTypeID componentTypeID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;


    /**
     *   Returns the all component type definitions for the specified <code>ComponentTypeID</code>.
     *   This includes the dependent definitions for service type components.
     *   @param componentTypeID is a ComponentTypeID
     *   @return Collection of ComponentTypeDefns
     *
     *   @see getDependentComponentTypeDefinitions(ComponentTypeID)
     */
    Collection getAllComponentTypeDefinitions(ComponentTypeID componentTypeID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a <code>List</code> of type <code>ComponentType</code> .
     * that are flagged as being monitored.  A component of this type is considered
     * to be available for monitoring statistics.
     * @param includeDeprecated true if class names that have been deprecated should be
     *    included in the returned list, or false if only non-deprecated constants should be returned.
     * @return Collection of type <code>ComponentType</code>
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     *
     * @see #ComponentType
     */
    Collection getMonitoredComponentTypes(boolean includeDeprecated)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     *  Returns a <code>ComponentType</code> for the specified <code>ComponentTypeID</code>
     *  @param id is for the requested component type.
     *  @return ComponentType based on the id
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    ComponentType getComponentType(ComponentTypeID id)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a <code>List</code> of type <code>ComponentType</code> that represents
     * all the ComponentTypes defined.  Note that this will include objects of
     * type ProductType (a subclass of ComponentType).
     * @param includeDeprecated true if class names that have been deprecated should be
     *    included in the returned list, or false if only non-deprecated constants should be returned.
     * @return Collection of type <code>ComponentType</code>
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @see ComponentType
     * @see #getAllProductTypes
     */
    Collection getAllComponentTypes(boolean includeDeprecated)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a <code>List</code> of type <code>ProductType</code> that represents
     * all the ProductTypes defined.
     * @param includeDeprecated true if class names that have been deprecated should be
     *    included in the returned list, or false if only non-deprecated constants should be returned.
     * @return Collection of type <code>ProductType</code>
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @see #ProductType
     */
    Collection getAllProductTypes(boolean includeDeprecated)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a <code>Host</code> for the specified <code>HostID</code>.
     * </br>
     * @return Host
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Host getHost(HostID hostID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a <code>Collection</code> of currently defined hosts.  This method does not cache, it reretrieves the data everytime.
     * </br>
     * @return Collection of type Host
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Collection getHosts()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a collection of <code>ComponentDefn</code>s 
     * for the specified collection of <code>ComponentDefnID</code>s
     * and <code>ConfigurationID</code>.  If the configuration is
     * null the parent name from the componentID will be used.
     * </br>
     * The reason for adding the option to specify the configurationID
     * is so that the same collection of componentIDs can be used
     * to obtain the componentDefns from the different configurations.
     * Otherwise, the requestor would have to create a new set
     * of componetDefnIDs for each configuration.
     * <br>
     * @param componentDefnIDs contains all the ids for which componet defns to be returned
     * @param configurationID is the configuration from which the component defns are to
     * be derived; optional, nullalble
     * @return Collection of ComponentDefn objects
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    Collection getComponentDefns(Collection componentDefnIDs, ConfigurationID configurationID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ResourceDescriptor ResourceDescriptor}
     * for all resource pools defined to the system.
     * @param configurationID is the configuration from which the component defns are to
     * be derived
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     * @see getResourcePool(ConfigurationID) 
     */
    //Collection getResourceDescriptors(ConfigurationID configurationID)
    //throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

   /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ComponentType ComponentType}
     * for all resource pool types of a specified configuration.
     * @param configurationID is the configuration from which the component types are to
     * be derived
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    Collection getResourcePoolTypes(ConfigurationID configurationID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

   /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ComponentType ComponentType}
     * that represent the pool types for which new {@link ResourceDescriptor ResourcePools} 
     * of these types can be created.  This means only these types have logic implemented to
     * make use of the resource pool.
     * @param configurationID is the configuration from which the component types are to
     * be derived
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    Collection getPoolableResourcePoolTypes(ConfigurationID configurationID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ResourceDescriptor ResourceDescriptor}
     * for all resource pools defined in a configuration.
     * @param configurationID is the configuration from which the component defns are to
     * be derived
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    Collection getResourcePools(ConfigurationID configurationID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ResourceDescriptor ResourceDescriptor}
     * for all resource pools of a specified type defined in a configuration.
     * @param configurationID is the configuration from which the component defns are to
     * be derived
     * @param componentTypeID indicates the type of pools in the configuration to return
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    Collection getResourcePools(ConfigurationID configurationID, ComponentTypeID componentTypeID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ResourceDescriptor ResourceDescriptor}
     * for all internal resources defined to the system.  The internal resources are not managed with
     * the other configuration related information.  They are not dictated based on which configuration
     * they will operate (i.e., next startup or operational);
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    Collection getResources()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Returns a Collection of {@link com.metamatrix.common.config.api.ResourceDescriptor ResourceDescriptor}
     * that are of the specified resource type.
     * @param componentTypeID that identifies the type of resources to be returned
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    Collection getResources(ComponentTypeID componentTypeID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;


   /**
     * Save the resource changes based on each {@link com.metamatrix.common.config.api.ResourceDescriptor ResourceDescriptor}
     * in the collection.
     * @param resourceDescriptors for the resources to be changed          * 
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurred in communicating with a component.
     */
    void saveResources(Collection resourceDescriptors)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;


   

    /**
     * Returns a <code>ComponentDefn</code> for the specified <code>ComponentDefnID</code>.
     * </br>
     * @return ComponentDefn
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     */
    ComponentDefn getComponentDefn(ConfigurationID configurationID, ComponentDefnID componentDefnID)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

   

    // --------------------------------------------------------------
    //                A C T I O N     M E T H O D S
    // --------------------------------------------------------------

    /**
     * Execute as a single transaction the specified action, and optionally
     * return the set of objects or object IDs that were affected/modified by the action.
     * @param action the definition of the action to be performed on data within
     * the repository.
     * @return the set of objects that were affected by this transaction.
     * @throws ModificationException if the target of the action is invalid, or
     * if the target object is not a supported class of targets.
     * @throws IllegalArgumentException if the action is null
     * or if the result specification is invalid
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    Set executeTransaction(ActionDefinition action)
    throws ModificationException, ConfigurationLockException, ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Execute a list of actions, and optionally
     * return the set of objects or object IDs that were affected/modified by the action.
     * @param actions the ordered list of actions that are to be performed on data within
     * the repository.
     * @return the set of objects that were affected by this transaction.
     * @throws ModificationException if the target of any of the actions is invalid, or
     * if the target object is not a supported class of targets.
     * @throws IllegalArgumentException if the action is null
     * or if the result specification is invalid
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    Set executeTransaction(List actions)
    throws ModificationException, ConfigurationLockException, ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Execute a list of insert actions and for actions on objects of type ComponentDefn or
     * DeployedComponent object,
     * it will have its configuration id resassigned, and optionally return the set of objects
     * or object IDs that were affected/modified by the action.  Only insert actions can be performed
     * here because changing a configuration id on a modify action has larger consiquences.  
     * @param assignConfigurationID the configuration for which any action for a component object will
     * have its configurationID set to this.
     * @param actions the ordered list of actions that are to be performed on data within
     * the repository.
     * @return the set of objects that were affected by this transaction.
     * @throws ModificationException if the target of any of the actions is invalid, or
     * an action that is not an insert, or
     * if the target object is not a supported class of targets.
     * @throws IllegalArgumentException if the action is null
     * or if the result specification is invalid
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    Set executeInsertTransaction(ConfigurationID assignConfigurationID, List actions)
    throws ModificationException, ConfigurationLockException, ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Undo the specified number of previously-committed transactions.
     * @param numberOfActions the number of actions in the history that are to be undone.
     * @return the set of objects that were affected by undoing these actions.
     * @throws IllegalArgumentException if the number is negative.
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
    */
    Set undoActionsAsTransaction(int numberOfActions)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Get the history of actions executed in transactions by this editor.
     * The actions at the front of the list will be those most recently executed.
     * @return the ordered list of actions in the history.
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    List getHistory()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Clear the history of all actions without undoing any of them.
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    void clearHistory()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Get the number of actions that are currently in the history.
     * @return the number of actions in the history.
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    int getHistorySize()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Set the limit on the number of actions in the history.  Note that the
     * history may at times be greater than this limit, because when actions
     * are removed from the history, all actions for a transactions are
     * removed at the same time.  If doing so would make the history size
     * smaller than the limit, no actions are removed.
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    int getHistoryLimit()
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    /**
     * Set the limit on the number of actions in the history.  Note that the
     * history may at times be greater than this limit, because when actions
     * are removed from the history, all actions for a transactions are
     * removed at the same time.  If doing so would make the history size
     * smaller than the limit, no actions are removed.
     * @throws ConfigurationException if an error occurred within or during
     * communication with the Metadata Service.
     */
    void setHistoryLimit(int maximumHistoryCount)
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    
    /**
     * Add a host to the Configuration 
     * 
     * @param hostName String name of Host to add to Configuration
     * @param properties
     * @return Host 
     * @throws ConfigurationException if an error occurred within or during communication with the Configuration Service.
     * @throws InvalidSessionException if there is not a valid administrative session
     * @throws AuthorizationException if the administrator does not have privileges to use this method
     * @throws MetaMatrixComponentException if a general remote system problem occurred
     * @since 4.3
     */
    Host addHost(String hostName, Properties properties) 
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;
    
    

    /**
     * Check whether the encrypted properties for the specified ComponentDefns can be decrypted.
     * @param defns List<ComponentDefn>
     * @return List<Boolean> in the same order as the paramater <code>defns</code>.
     * For each, true if the properties could be decrypted for that defn.
     * @throws ConfigurationException
     * @throws InvalidSessionException
     * @throws AuthorizationException
     * @throws MetaMatrixComponentException
     * @since 4.3
     */
    List checkPropertiesDecryptable(List defns) 
    throws ConfigurationException, InvalidSessionException, AuthorizationException, MetaMatrixComponentException;

    
    
    /**
     * Obtain the Collection of {@link com.metamatrix.common.config.api.ReleaseInfo} objects
     * which represent the products of the system.  Each ReleaseInfo contains
     * the name of the product, as well as release info.
     * @return Collection of ReleaseInfo objects containing names of licensed
     * products, as well as other release info
     * @throws AuthorizationException if caller is not authorized to perform this method.
     * @throws InvalidSessionException if the <code>callerSessionID</code> is not valid or is expired.
     * @throws MetaMatrixComponentException if an error occurs in communicating with a component.
     */
    public abstract Collection getProducts() throws AuthorizationException,
        InvalidSessionException,
        MetaMatrixComponentException;

    
}

